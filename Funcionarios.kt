

data class Funcionarios (val nome: String, val matricula: Int, val salario: Double)

fun main() {

    //Funcionarios

    val listaFuncionarios = mutableListOf<Funcionarios>()

    while (true) {

        println("Menu")
        println("1- Cadastrar empregados")
        println("2- Pesquisar empregado por número de matricula")
        println("3- Pessoas que recebem mais que 1.000")
        println("4- Pessoas que recebem menos que 1.000")
        println("5- Pessoas que recebem 1.000")
        println("6- Sair")

        val escolha = readLine()?.toIntOrNull()

        when (escolha) {

            1 -> cadastrarEmpregados(listaFuncionarios)
            2 -> pesquisarEmpregados(listaFuncionarios)
            3 -> acimade100(listaFuncionarios)
            4 -> menorque100(listaFuncionarios)
            5 -> iguala100(listaFuncionarios)
            6 -> {
                println("Até logo")
                break
            }

            else -> println("Opção inválida")
        }
    }
}
fun cadastrarEmpregados(listaFuncionarios: MutableList<Funcionarios>){

    println("Nome: ")
    val nome = readln()

    println("Matricula: ")
    val matricula = readln().toInt()

    println("Quanto recebe: ")
    val salario = readln().toDouble()

    listaFuncionarios.add(Funcionarios(nome, matricula, salario))
    listaFuncionarios.sortBy { it.matricula }
}

fun pesquisarEmpregados(listaFuncionarios: List<Funcionarios>){

    println("__Pesquise no registro__")

    println("Informe qual registro deseja saber pela matricula: ")
    val resposta = readln().toInt()

    val pesquisa = listaFuncionarios.find { it.matricula.equals(resposta) }

    if (pesquisa != null){
        println(pesquisa)
    }else{
        println("Registro não encontrado.")
    }

}
fun acimade100(listaFuncionarios: List<Funcionarios>) {

    println("Pessoas com valores maiores que 1.000")
    var maior = listaFuncionarios.filter { it.salario > 1000 }

    if (maior.isEmpty()) {
        println("Não há registros encontrados.")
    } else {
        maior.forEach { println("Matricula: ${it.matricula} Nome: ${it.nome} Salario: ${it.salario}") }

    }
}

fun menorque100(listaFuncionarios: List<Funcionarios>) {

    println("Pessoas com valores menores que 1.000")
    var menor = listaFuncionarios.filter { it.salario < 1000 }

    if (menor.isEmpty()) {
        println("Não há registros encontrados.")
    } else {
        menor.forEach { println("Matricula: ${it.matricula} Nome: ${it.nome} Salario: ${it.salario}") }

    }
}

fun iguala100(listaFuncionarios: List<Funcionarios>){

    println("Pessoas que recebem 1.000")
    var igual = listaFuncionarios.filter { it.salario == 1.000 }

    if (igual.isEmpty()) {
        println("Não há registros encontrados.")
    } else {
        igual.forEach { println("Matricula: ${it.matricula} Nome: ${it.nome} Salario: ${it.salario}") }

    }
}