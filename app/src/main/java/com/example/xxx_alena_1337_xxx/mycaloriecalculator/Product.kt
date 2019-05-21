package com.example.xxx_alena_1337_xxx.mycaloriecalculator

class Product {



    var product_name: String?=null
    var proteins: String?=null
    var fats: String?=null
    var carbs: String?=null
    var calories: String?=null

    constructor(){}

    constructor(product_name:String?,proteins:String?,fats:String?,carbs:String?,calories:String?){
        this.product_name=product_name
        this.proteins=proteins
        this.fats=fats
        this.carbs=carbs
        this.calories=calories

    }


}