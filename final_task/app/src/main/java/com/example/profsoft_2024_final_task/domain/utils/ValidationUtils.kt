package com.example.profsoft_2024_final_task.domain.utils

private const val minPasswordLength = 8

fun String.isValidPhone(): Boolean {
    return validatePhone(this)
}

fun String.isCorrectPhoneSymbolsAndLength(): Boolean {
    return validatePhoneSymbolsAndLength(this)
}

fun String.isValidPassword(): Boolean {
    return validatePassword(this)
}

fun String.isValidName(): Boolean {
    return validateName(this)
}

private fun validatePhoneSymbols(phone: String): Boolean {
    val phoneNumberRegex = "^[+]?[0-9]*\$".toRegex()
    if (phone.isEmpty()) return true
    return (!phone.startsWith("0") && !phone.startsWith("+0") && phone.matches(phoneNumberRegex))
}

private fun validatePhoneSymbolsAndLength(phone: String): Boolean {
    val length = if (phone.startsWith("+")) 12 else 11
    return (validatePhoneSymbols(phone) && phone.length <= length)
}

private fun validatePhone(phone: String): Boolean {
    if (phone.isEmpty() || !validatePhoneSymbols(phone)) return false

    if (phone.startsWith("+7") && phone.length == 12) return true
    else if ((phone.startsWith("7") || phone.startsWith("8")) && phone.length == 11) return true
    return false
}

private fun validatePassword(password: String): Boolean {
    return password.length >= minPasswordLength
}

private fun validateName(name: String): Boolean {
    val nameRegexEn = "^[A-Za-z ]*$".toRegex()
    val nameRegexRu = "^[А-Яа-я ]*$".toRegex()

    return name.matches(nameRegexEn) || name.matches(nameRegexRu)
}