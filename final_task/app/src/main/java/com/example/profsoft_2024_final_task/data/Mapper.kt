package com.example.profsoft_2024_final_task.data

import com.example.profsoft_2024_final_task.data.dto.RegisterUserRequestBody
import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam

fun mapToRegisterUserRequestBody(param: RegisterUserParam): RegisterUserRequestBody {
    return RegisterUserRequestBody(
        phone = param.phoneNumber,
        passwordHashed = param.password,
        name = param.firstName,
        surname = param.lastName,
        avatar = null
    )
}