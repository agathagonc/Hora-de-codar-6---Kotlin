//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



    data class Aluno (val nome: String, val media: Double, val resultado: String)

    fun main(){

        //Nota

        val listaAluno = mutableListOf<Aluno>()

        while (true) {

            println("Menu")
            println("1 - Cadastrar Alunos")
            println("2 - Pesquisar por nomes")
            println("3 - Apresentar alunos")
            println("4 - sair")

            val escolha = readLine()?.toIntOrNull()

            when (escolha) {
                1 -> cadastrarAlunos(listaAluno)
                2 -> pesquisarAlunos(listaAluno)
                3 -> apresentarAlunos(listaAluno)
                4 -> {
                    println("Volte sempre que precisar para cadastrar um aluno.")
                    break
                }

                else -> println("Opção inválida")
            }
        }
    }

    fun cadastrarAlunos(listaAluno: MutableList<Aluno>) {

        if (listaAluno.size >= 20) {
            println("Lista cheia")
        } else {

            println("Informe os dados dos alunos.")

            println("Nome: ")
            val nome = readln()

            println("Digite a primeira nota: ")
            val nota1 = readln().toDouble()

            println("Digite a segunda nota: ")
            val nota2 = readln().toDouble()

            val media = (nota1 + nota2) / 2

            var resultado = ""

            if (media >= 5) {
                resultado = "Aprovado"
            } else {
                resultado = "Reprovado"
            }

            listaAluno.add(Aluno(nome, media, resultado))
            listaAluno.sortBy { it.nome }

        }
    }
    fun pesquisarAlunos(listaAluno: List<Aluno>){

        if(listaAluno.isEmpty()){
            println("Lista vazia")
        } else {

            println("___Pesquise no registro___")

            println("Informe qual registro deseja saber pelo nome: ")
            val pesquisa = readln()

            val nome2 = listaAluno.find { it.nome.equals(pesquisa, ignoreCase = true) }

            if (nome2 != null) {
                println(nome2)
            } else {
                println("Registro não encontrado.")
            }
        }
    }

    fun apresentarAlunos(listaAluno: List<Aluno>) {

        if (listaAluno.isEmpty()) {
            println("Lista vazia")
        } else {

            listaAluno.forEach { println(it) }
        }
    }