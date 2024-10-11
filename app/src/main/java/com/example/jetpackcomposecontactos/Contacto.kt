package com.example.jetpackcomposecontactos

data class Contacto (val nombre: String, val tfno: String, val imagen: Int) {

    fun GetInitials(): String {
        var initials = StringBuilder(nombre)
        var words = initials.split(" ")
        var actualInitials = ""
        var iterator = words.iterator()

        iterator.forEach {
            var initial = it.toCharArray()[0]
            actualInitials += "$initial."
        }

        return actualInitials
    }
}