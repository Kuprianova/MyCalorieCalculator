package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import com.chibatching.kotpref.KotprefModel

object UserInfo : KotprefModel() {
    var uid by nullableStringPref()
}