enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudosEducacionais: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        alunos.forEach { aluno ->
            if (aluno !in inscritos) {
                inscritos.add(aluno)
                println("Aluno ${aluno.nome} matriculado com sucesso na formação $nome.")
            } else {
                println("Aluno ${aluno.nome} já está matriculado na formação $nome.")
            }
        }
    }

    fun listarInscritos() {
        if (inscritos.isNotEmpty()) {
            println("Lista de alunos inscritos na formação $nome:")
            inscritos.forEach { println(it.nome) }
        } else {
            println("Nenhum aluno matriculado na formação $nome.")
        }
    }
}

fun main() {
  
    val kotlinIntro = ConteudoEducacional(nome = "Introdução ao Kotlin")
    val androidBasics = ConteudoEducacional(nome = "Fundamentos de Android", duracao = 120)
    val formacaoAndroid = Formacao(
        nome = "Desenvolvedor Android",
        nivel = Nivel.INTERMEDIARIO,
        conteudosEducacionais = listOf(kotlinIntro, androidBasics)
    )
    val aluno1 = Aluno(nome = "Maria")
    val aluno2 = Aluno(nome = "João")

    formacaoAndroid.matricular(aluno1, aluno2)
    formacaoAndroid.listarInscritos()
}
