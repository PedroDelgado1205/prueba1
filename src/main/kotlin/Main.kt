class Libro(val titulo: String, val autor: String, val anioPublicacion: Int) {
    var disponible: Boolean = true
}

class Usuario(val nombre: String, val edad: Int) {
    val librosPrestados: MutableList<Libro> = mutableListOf()
}

class Biblioteca {
    val librosDisponibles: MutableList<Libro> = mutableListOf()
    val usuariosRegistrados: MutableList<Usuario> = mutableListOf()

    fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
        println("Usuario ${usuario.nombre} registrado con éxito.")
    }

    fun agregarLibro(libro: Libro) {
        librosDisponibles.add(libro)
        println("Libro '${libro.titulo}' agregado al inventario.")
    }

    fun prestarLibro(libro: Libro, usuario: Usuario) {
        if (libro in librosDisponibles && libro.disponible) {
            libro.disponible = false
            usuario.librosPrestados.add(libro)
            println("Libro '${libro.titulo}' prestado a ${usuario.nombre}.")
        } else {
            println("El libro no está disponible para préstamo.")
        }
    }

    fun mostrarLibrosDisponibles() {
        println("Libros disponibles en la biblioteca:")
        librosDisponibles.forEach { libro ->
            println("${libro.titulo} - ${libro.autor} (${libro.anioPublicacion})")
        }
    }

    fun mostrarUsuariosRegistrados() {
        println("Usuarios registrados en la biblioteca:")
        usuariosRegistrados.forEach { usuario ->
            println("${usuario.nombre} - ${usuario.edad} años")
        }
    }
}

fun main() {
    val libro1 = Libro("La Sombra del Viento", "Carlos Ruiz Zafón", 2001)
    val libro2 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967)
    val libro3 = Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997)
    val libro4 = Libro("1984", "George Orwell", 1949)
    val libro5 = Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954)

    val usuario1 = Usuario("Juan", 25)
    val usuario2 = Usuario("Ana", 30)

    val biblioteca = Biblioteca()

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    biblioteca.agregarLibro(libro1)
    biblioteca.agregarLibro(libro2)
    biblioteca.agregarLibro(libro3)
    biblioteca.agregarLibro(libro4)
    biblioteca.agregarLibro(libro5)

    biblioteca.prestarLibro(libro1, usuario1)
    biblioteca.prestarLibro(libro3, usuario2)

    biblioteca.mostrarUsuariosRegistrados()
    biblioteca.mostrarLibrosDisponibles()
}
