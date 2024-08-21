package com.example.profsoft_2024_final_task.data

import com.example.profsoft_2024_final_task.data.dto.AuthorizeUserRequestBody
import com.example.profsoft_2024_final_task.data.dto.AuthorizeUserResponse
import com.example.profsoft_2024_final_task.data.dto.RegisterUserRequestBody
import com.example.profsoft_2024_final_task.data.dto.RegisterUserResponse
import com.example.profsoft_2024_final_task.domain.model.AuthorizeResult
import com.example.profsoft_2024_final_task.domain.model.AuthorizeUserParam
import com.example.profsoft_2024_final_task.domain.model.RegisterResult
import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam

fun mapToRegisterUserRequestBody(param: RegisterUserParam): RegisterUserRequestBody {
    return RegisterUserRequestBody(
        phone = param.phoneNumber,
        passwordHashed = param.password,
        name = param.firstName,
        surname = param.lastName,
        avatar = "string"
    )
}

fun mapToAuthorizeUserRequestBody(param: AuthorizeUserParam): AuthorizeUserRequestBody {
    return AuthorizeUserRequestBody(
        phone = param.phoneNumber,
        passwordHashed = param.password
    )
}

fun mapToAuthorizeResult(authorizeUserResponse: AuthorizeUserResponse?): AuthorizeResult {
    if (authorizeUserResponse == null) return AuthorizeResult(
        isSuccess = false,
        token = null
    )
    else if (authorizeUserResponse.data == null) {
        return AuthorizeResult(
            isSuccess = false,
            token = null
        )
    }
    return AuthorizeResult(
        isSuccess = true,
        token = authorizeUserResponse.data.token
    )
}

fun mapToRegisterResult(registrationResponse: RegisterUserResponse?): RegisterResult {
    if (registrationResponse == null) return RegisterResult(
        isSuccess = false,
        message = null,
        token = null
    )
    else if (registrationResponse.data == null) {
        return RegisterResult(
            isSuccess = false,
            message = null,
            token = null
        )
    }
    return RegisterResult(
        isSuccess = true,
        message = registrationResponse.message,
        token = registrationResponse.data.token
    )
}