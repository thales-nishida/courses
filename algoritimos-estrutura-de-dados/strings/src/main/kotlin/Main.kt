package br.com.thalesnishida

fun main() {
    checkPassword("Asasasasa@2121")
}

fun formatCPF(cpf: String): String {
    val regex = Regex("\\D")
    val formated = cpf.replace(regex, "")
    return formated
}

//Problema "dominio-email"
//Dado um email de uma pessoa, mostrar o nome de usuário e o domínio deste email. O programa deve também informar se o domínio é brasileiro (.br). Supor um email válido.
//
//Exemplo 1:
//Entrada	Saída
//joao.silva23@yahoo.com.br	Usuario: joao.silva23
//Dominio: yahoo.com.br
//Brasileiro: sim
//
//Exemplo 2:
//Entrada	Saída
//maria123@gmail.com	Usuario: maria123
//Dominio: gmail.com
//Brasileiro: nao
//
//Assinaturas:
//
//Javascript:
//function extractEmailInformation(email)
//
//Java:
//public static EmailInfo extractEmailInformation(String email)
//
//C#:
//public static EmailInfo ExtractEmailInformation(string email)
//
//Python:
//def extract_email_information(email)
data class InformationUser(
    val user: String,
    val domain: String,
    val isBrazilian: Boolean
)

fun resolveDomainEmail(userInformation: String): InformationUser {
    val (user, domain) = userInformation.split("@").let {
        it[0] to it.getOrElse(1) { "" }
    }

    val isBrazilian = domain.endsWith(".br", ignoreCase = false)

    return InformationUser(user, domain, isBrazilian).also {
        println(it)
    }
}

//Problema "data1"
//Dada uma data que poderá estar no formado dia/mês/ano, sendo que o dia e mês menor que 10 pode ou
// não ter zero à esquerda, mostrar o dia, mês e ano separadamente, na forma numérica. Supor uma data válida.
//
//Exemplo:
//Entrada	Saída
//21/07/2010
// Dia: 21
//Mês: 7
//Ano: 2010
//
//Assinaturas:
//
//Javascript:
//function extractDateData(date)
//
//Java:
//public static DateInfo extractDateData(String date)
//
//C#:
//public static DateInfo ExtractDateData(string date)
//
//Python:
//def extract_date_data(date)
//
data class Date(
    val day: String,
    val month: String,
    val year: String,
)

fun extractedInformationByDate(data: String): Date {
    val regex = Regex("^(\\d{2})/(\\d{2})/(\\d{4})$")
    val isValidDate =
        regex.matchEntire(data) ?: throw IllegalArgumentException("Invalid data format, correct format: DD/MM/YYYY")

    val (day, month, year) = data.split("/").also {
        println(
            Date(
                it[0],
                it[1],
                it[2]
            )
        )
    }
    return Date(day, month, year)
}

//Problema "data2"
//Dados um dia, mês e ano, produzir um string no formato dd/mm/aaaa, preenchendo com zeros à esquerda o dia e mês, se necessário.
//
//Exemplo:
//Entrada	Saída
//{
//    "day": 21,
//    "month": 7,
//    "year": 2010
//}	21/07/2010
//
//Assinaturas:
//
//Javascript:
//function formatDate(day, month, year)
//
//Java:
//public static String formatDate(int day, int month, int year)
//
//C#:
//public static string FormatDate(int day, int month, int year)
//
//Python:
//def format_date(day, month, year)

fun editDate(date: String): String {
    val dateSplit = date.split("/")

    val (day, month, year) = dateSplit

    return "%02d/%02d/%04d".format(day.toInt(), month.toInt(), year.toInt())
}

//Problema "senha"
//Um sistema exige que, no cadastro, a senha do usuário tenha pelo menos 8 caracteres no total,
// pelo menos uma letra (maiúscula ou minúscula), pelo menos um dígito e pelo menos um caractere especial: @, #, &.
// Fazer um programa para dizer se uma dada senha é válida ou inválida.
//
//Exemplo 1:
//Entrada	Saída
//amerca1@	VALIDA
//
//Exemplo 2:
//Entrada	Saída
//amrca154682	INVALIDA
//
//Assinaturas:
//
//Javascript:
//function validatePassword(str)
//
//Java:
//public static boolean validatePassword(String str)
//
//C#:
//public static bool ValidatePassword(string str)
//
//Python:
//def validate_password(string)

fun checkPassword(password: String) {
    val regex = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#&]).{8,}$")
    val isValidPassword = regex.matches(password)
    if (isValidPassword) {
        println("Password: $password, isValid")
    } else {
        println("Password: $password, inValid")
    }
}