import java.util.Date

class Usuario (

    var id: Int,
    var idAplicacion: Int,
    var nombre: String,
    var apellido: String,
    var correo: String,
    var fechaNacimiento: String,
    var genero: String


){
    override fun toString(): String {
        return (ANSI_BLUE +"${id}\t\t ${idAplicacion}\t\t ${nombre}\t\t ${apellido}\t\t\t ${correo}\t\t\t ${genero}")
    }
}