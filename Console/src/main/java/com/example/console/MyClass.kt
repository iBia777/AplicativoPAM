package com.example.console

// ==========================================
// 1. ENUMS E CLASSES DE DADOS
// ==========================================

enum class Naipe {
    OUROS, ESPADAS, COPAS, PAUS
}

enum class ValorCarta(val pontos: Int) {
    AS(1), DOIS(2), TRES(3), DEZ(10), VALETE(10), DAMA(10), REI(10)
}

data class Carta(val valor: ValorCarta, val naipe: Naipe) {
    override fun toString(): String {
        return "${valor.name} de $naipe"
    }
}

// ==========================================
// 2. BARALHO E COMPOSIÇÃO
// ==========================================

class Baralho {
    private val cartas = mutableListOf<Carta>()

    init {
        for (naipe in Naipe.values()) {
            for (valor in ValorCarta.values()) {
                cartas.add(Carta(valor, naipe))
            }
        }
        cartas.shuffle()
    }

    val restantes: Int
        get() = cartas.size

    fun comprar(): Carta {
        return cartas.removeAt(0)
    }
}

// ==========================================
// 3. HERANÇA E POLIMORFISMO
// ==========================================

open class JogadorBase(val nome: String) {
    var pontos = 0
        private set

    open fun querComprar(): Boolean {
        return pontos < 15
    }

    fun ganhar(quantidade: Int) {
        if (quantidade > 0) {
            pontos += quantidade
        }
    }

    fun apresentar() {
        println("$nome tem $pontos pontos")
    }
}

class Banca(nome: String) : JogadorBase(nome) {
    override fun querComprar(): Boolean {
        return pontos < 17
    }
}

// ==========================================
// 4. INTERFACES
// ==========================================

interface Jogo {
    fun pontuar(valores: List<Int>): Int
}

class VinteEUm : Jogo {
    override fun pontuar(valores: List<Int>): Int {
        return valores.sum()
    }
}

class MaiorCarta : Jogo {
    override fun pontuar(valores: List<Int>): Int {
        return valores.maxOrNull() ?: 0
    }
}

fun mostrarPontos(jogo: Jogo, mao: List<Int>) {
    println("Pontuação calculada: ${jogo.pontuar(mao)}")
}

// ==========================================
// 5. FUNÇÃO PRINCIPAL (MAIN) UNIFICADA
// ==========================================

fun main() {
    println("--- 1. O PRIMEIRO PROGRAMA ---")
    println("Olá, turma!")

    println("\n--- 2. VARIÁVEIS E TIPOS ---")
    val nome: String = "Ana"
    var pontos: Int = 21
    println("Jogadora: $nome, Pontos: $pontos, Dobro: ${pontos * 2}")

    println("\n--- 3. TESTANDO O BARALHO E COMPOSIÇÃO ---")
    val baralho = Baralho()
    println("Cartas restantes no baralho: ${baralho.restantes}")
    val cartaComprada = baralho.comprar()
    println("Carta comprada: $cartaComprada")
    println("Cartas restantes após compra: ${baralho.restantes}")

    println("\n--- 4. HERANÇA (BANCA VS JOGADOR) ---")
    val banca = Banca("Banca Oficial")
    banca.ganhar(16)
    banca.apresentar()
    println("A banca quer comprar mais? ${banca.querComprar()}")

    println("\n--- 5. INTERFACES E POLIMORFISMO ---")
    val maoValores = listOf(10, 5, 3)
    mostrarPontos(VinteEUm(), maoValores)
    mostrarPontos(MaiorCarta(), maoValores)

    println("\n--- 6. LISTAS FIXAS (listOf) ---")
    val naipes = listOf("Ouro", "Espada", "Copa", "ZAP")
    println("Primeiro item: ${naipes[0]}")
    println("Quantidade de itens: ${naipes.size}")
    for (naipe in naipes) {
        println(naipe)
    }

    println("\n--- 7. LISTAS MUTÁVEIS (mutableListOf) ---")
    val mao = mutableListOf<String>()
    mao.add("Ás de ♠")
    mao.add("Rei de ♥")
    println("Mão inicial: $mao")

    mao.removeAt(0)
    println("Tamanho após remover o item 0: ${mao.size}")

    mao.shuffle()
    println("Mão embaralhada: $mao")
}