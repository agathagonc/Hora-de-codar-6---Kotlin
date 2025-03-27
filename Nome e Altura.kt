//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    //Nome e Altura

    data class Pessoa(
        val nome: String,
        val altura: Double
    )

    fun main() {
        val listaPessoas = mutableListOf<Pessoa>()
        var opcao: Int

        do {
            println("\n===== MENU ALTURA =====")
            println("1. Cadastrar 15 pessoas")
            println("2. Pessoas com altura <= 1.5m")
            println("3. Pessoas com altura > 1.5m")
            println("4. Pessoas com altura > 1.5m e < 2.0m")
            println("5. Média das alturas")
            println("6. Sair")
            print("Escolha uma opção: ")

            opcao = readLine()?.toIntOrNull() ?: -1

            when (opcao) {
                1 -> {
                    listaPessoas.clear()
                    for (i in 1..15) {
                        println("\nPessoa $i:")
                        print("Nome: ")
                        val nome = readLine().orEmpty()
                        print("Altura (em metros, ex: 1.72): ")
                        val altura = readLine()?.toDoubleOrNull() ?: 0.0
                        listaPessoas.add(Pessoa(nome, altura))
                    }
                    println("Cadastro concluído.")
                }

                2 -> {
                    println("\nPessoas com altura <= 1.5m:")
                    listaPessoas.filter { it.altura <= 1.5 }
                        .forEach { println("Nome: ${it.nome}, Altura: ${"%.2f".format(it.altura)} m") }
                }

                3 -> {
                    println("\nPessoas com altura > 1.5m:")
                    listaPessoas.filter { it.altura > 1.5 }
                        .forEach { println("Nome: ${it.nome}, Altura: ${"%.2f".format(it.altura)} m") }
                }

                4 -> {
                    println("\nPessoas com altura entre 1.5m e 2.0m:")
                    listaPessoas.filter { it.altura > 1.5 && it.altura < 2.0 }
                        .forEach { println("Nome: ${it.nome}, Altura: ${"%.2f".format(it.altura)} m") }
                }

                5 -> {
                    if (listaPessoas.isNotEmpty()) {
                        val media = listaPessoas.map { it.altura }.average()
                        println("Média das alturas: ${"%.2f".format(media)} m")
                    } else {
                        println("Nenhuma pessoa cadastrada para calcular a média.")
                    }
                }

                6 -> println("Encerrando o programa...")

                else -> println("Opção inválida. Tente novamente.")
            }

        } while (opcao != 6)
    }
