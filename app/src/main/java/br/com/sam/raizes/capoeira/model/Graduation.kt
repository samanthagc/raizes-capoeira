package br.com.sam.raizes.capoeira.model

enum class Graduation(val rope: String) {
    STUDENT_1_CHIELD("Ponta Amarela"),
    STUDENT_2_CHIELD("Ponta Amarela e Laranja"),
    STUDENT_3_CHIELD("Ponta Laranja"),
    STUDENT_4_CHIELD("Ponta Laranja e Azul"),
    STUDENT_5_CHIELD("Ponta Azul"),
    STUDENT_1("Crua e Amarela"),
    STUDENT_2("Amarela"),
    STUDENT_3("Amarela e Laranja"),
    STUDENT_4("Laranja"),
    STUDENT_5("Laranja e Azul"),
    STUDENT_6("Azul"),
    GRADUATE("Azul e Verde"),
    INTERN("Verde"),
    MONITOR("Verde e Roxa"),
    INSTRUCTOR("Roxa"),
    TEACHER("Roxa e Marrom"),
    FOREMAN("Marrom"),
    FIRST_DEGREE_MASTER("Marrom e Vermelha"),
    SECOND_DEGREE_MASTER("Vermelha"),
    THIRD_DEGREE_MASTER("Vermelha e Branca"),
    MASTER("Branca")
}