package com.example.network

import com.example.common.domain.model.AuthorizeResult
import com.example.common.domain.model.AuthorizeUserParam
import com.example.common.domain.model.RegisterResult
import com.example.common.domain.model.RegisterUserParam
import com.example.network.dto.AuthorizeUserRequestBody
import com.example.network.dto.AuthorizeUserResponse
import com.example.network.dto.RegisterUserRequestBody
import com.example.network.dto.RegisterUserResponse

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