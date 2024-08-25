package com.example.network

import com.example.common.domain.model.authenticated.Course
import com.example.common.domain.model.authenticated.Text
import com.example.common.domain.model.unauthenticated.AuthorizeResult
import com.example.common.domain.model.unauthenticated.AuthorizeUserParam
import com.example.common.domain.model.unauthenticated.RegisterResult
import com.example.common.domain.model.unauthenticated.RegisterUserParam
import com.example.network.dto.authenticated.CourseResponse
import com.example.network.dto.authenticated.TextDto
import com.example.network.dto.unauthenticated.AuthorizeUserRequestBody
import com.example.network.dto.unauthenticated.AuthorizeUserResponse
import com.example.network.dto.unauthenticated.RegisterUserRequestBody
import com.example.network.dto.unauthenticated.RegisterUserResponse

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
    if (authorizeUserResponse?.data == null) return AuthorizeResult(
        isSuccess = false,
        token = null
    )

    return AuthorizeResult(
        isSuccess = true,
        token = authorizeUserResponse.data.token
    )
}

fun mapToRegisterResult(registrationResponse: RegisterUserResponse?): RegisterResult {
    if (registrationResponse?.data == null) return RegisterResult(
        isSuccess = false,
        message = null,
        token = null
    )

    return RegisterResult(
        isSuccess = true,
        message = registrationResponse.message,
        token = registrationResponse.data.token
    )
}

fun mapToCourse(courseResponse: CourseResponse?): Course {
    if (courseResponse?.data == null) return Course(
        isSuccess = false,
        id = "",
        title = "",
        description = "",
    )

    return Course(
        isSuccess = true,
        id = courseResponse.data.id,
        title = courseResponse.data.title,
        description = courseResponse.data.description,
        tags = courseResponse.data.tags,
        text = courseResponse.data.text.map { mapToText(it) }
    )
}

fun mapToText(textDto: TextDto): Text {
    return Text(text = textDto.text, imageUrl = textDto.image)
}