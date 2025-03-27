//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

//Agenda


    data class Contato(
        var nome: String,
        var endereco: String,
        var telefone: String
    )

    fun main() {
        val agenda = mutableListOf<Contato>()
        var opcao: Int

        do {
            println("\n===== MENU AGENDA =====")
            println("1. Cadastrar 10 contatos")
            println("2. Pesquisar contato por nome")
            println("3. Classificar contatos por nome")
            println("4. Apresentar todos os contatos")
            println("5. Sair")
            print("Escolha uma opção: ")

            opcao = readLine()?.toIntOrNull() ?: -1

            when (opcao) {
                1 -> {
                    agenda.clear()
                    for (i in 1..10) {
                        println("\nContato $i:")
                        print("Nome: ")
                        val nome = readLine().orEmpty()
                        print("Endereço: ")
                        val endereco = readLine().orEmpty()
                        print("Telefone: ")
                        val telefone = readLine().orEmpty()
                        agenda.add(Contato(nome, endereco, telefone))
                    }
                    println("Contatos cadastrados com sucesso!")
                }

                2 -> {
                    if (agenda.isEmpty()) {
                        println("Nenhum contato cadastrado!")
                    } else {
                        print("Digite o nome para pesquisar: ")
                        val nomeBusca = readLine().orEmpty()
                        val contato = agenda.find { it.nome.equals(nomeBusca, ignoreCase = true) }
                        if (contato != null) {
                            println("Contato encontrado: $contato")
                        } else {
                            println("Contato não encontrado.")
                        }
                    }
                }

                3 -> {
                    if (agenda.isEmpty()) {
                        println("Nenhum contato para ordenar!")
                    } else {
                        agenda.sortBy { it.nome.lowercase() }
                        println("Contatos ordenados por nome com sucesso.")
                    }
                }

                4 -> {
                    if (agenda.isEmpty()) {
                        println("Nenhum contato para exibir!")
                    } else {
                        println("\n===== Lista de Contatos =====")
                        agenda.forEachIndexed { index, contato ->
                            println("${index + 1}. Nome: ${contato.nome}, Endereço: ${contato.endereco}, Telefone: ${contato.telefone}")
                        }
                    }
                }

                5 -> println("Encerrando o programa...")

                else -> println("Opção inválida. Tente novamente.")

            }

        } while (opcao != 5)
    }
