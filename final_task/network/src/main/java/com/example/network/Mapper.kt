package com.example.network

import com.example.common.domain.model.authenticated.Author
import com.example.common.domain.model.authenticated.Comment
import com.example.common.domain.model.authenticated.CommunityNote
import com.example.common.domain.model.authenticated.CommunityNotePreview
import com.example.common.domain.model.authenticated.CommunityNotePreviewResult
import com.example.common.domain.model.authenticated.CoursesPreviewResult
import com.example.common.domain.model.authenticated.Text
import com.example.common.domain.model.unauthenticated.AuthorizeResult
import com.example.common.domain.model.unauthenticated.AuthorizeUserParam
import com.example.common.domain.model.unauthenticated.RegisterResult
import com.example.common.domain.model.unauthenticated.RegisterUserParam
import com.example.network.dto.authenticated.AuthorDto
import com.example.network.dto.authenticated.CommentDto
import com.example.network.dto.authenticated.course.CourseDto
import com.example.network.dto.authenticated.TextDto
import com.example.network.dto.authenticated.note.NoteDto
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
        phone = param.phoneNumber, passwordHashed = param.password
    )
}

fun mapToAuthorizeResult(authorizeUserResponse: AuthorizeUserResponse?): AuthorizeResult {
    if (authorizeUserResponse?.data == null) return AuthorizeResult(
        isSuccess = false, token = null
    )

    return AuthorizeResult(
        isSuccess = true, token = authorizeUserResponse.data.token
    )
}

fun mapToRegisterResult(registrationResponse: RegisterUserResponse?): RegisterResult {
    if (registrationResponse?.data == null) return RegisterResult(
        isSuccess = false, message = null, token = null
    )

    return RegisterResult(
        isSuccess = true,
        message = registrationResponse.message,
        token = registrationResponse.data.token
    )
}

fun mapToCourse(courseDto: CourseDto): CoursesPreviewResult {
    return CoursesPreviewResult(
        id = courseDto.id,
        title = courseDto.title,
        description = courseDto.description,
        tags = courseDto.tags,
        text = courseDto.text.map { mapToText(it) }
    )
}

fun mapToText(textDto: TextDto): Text {
    return Text(text = textDto.text, imageUrl = textDto.image)
}

fun mapToCommunityNotePreview(noteDto: NoteDto): CommunityNotePreviewResult {
    return CommunityNotePreviewResult(
        data = CommunityNotePreview(
            id = noteDto.id,
            title = noteDto.title,
            description = noteDto.content.first().text,
            date = noteDto.date,
            author = mapToAuthor(noteDto.author)
        ),
    )
}

fun mapToCommunityNote(noteDto: NoteDto): CommunityNote {
    return CommunityNote(
        id = noteDto.id,
        title = noteDto.title,
        text = noteDto.content.map { mapToText(it) },
        date = noteDto.date,
        author = mapToAuthor(noteDto.author),
        comments = noteDto.comments.map { mapToComment(it) }
    )
}

fun mapToComment(commentDto: CommentDto): Comment {
    return Comment(
        id = commentDto.id,
        author = mapToAuthor(commentDto.author),
        text = commentDto.text
    )
}

fun mapToAuthor(authorDto: AuthorDto): Author {
    return Author(
        id = authorDto.id,
        name = authorDto.name,
        surname = authorDto.surname,
        avatarUrl = authorDto.avatar,
        role = authorDto.role
    )
}