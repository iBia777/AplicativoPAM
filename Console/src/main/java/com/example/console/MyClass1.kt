enum class Naipe { OUROS, ESPADAS, COPAS, PAUS }
enum class Valor { AS, DOIS, TRES }
data class Carta(val valor: Valor, val naipe: Naipe)
class Baralho {
    private val cartas = mutableListOf<Carta>()
    init {
        for (naipe in Naipe.values()) {
            for (valor in Valor.values()) {
                cartas.add(Carta(valor, naipe))
            }
        }
    }
    val restantes: Int
        get() = cartas.size
    fun comprar(): Carta {
        return cartas.removeAt(0)
    }
}
fun main() {
    val baralho = Baralho()
    println(baralho.restantes)
    println(baralho.comprar())
    println(baralho.restantes)
}