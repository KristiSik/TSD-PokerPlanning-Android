package com.tsdproject.pokerplanning.service

import com.tsdproject.pokerplanning.service.api.UsersApi

object ServiceProvider {

    const val SERVICE_ENDPOINT = "http://18.191.100.184/api/"

    var usersService: UsersApi =
            ServiceFactory.createRetrofitService(UsersApi::class.java, SERVICE_ENDPOINT)

}