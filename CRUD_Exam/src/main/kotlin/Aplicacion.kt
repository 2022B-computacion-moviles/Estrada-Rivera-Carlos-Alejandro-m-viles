import java.util.ArrayList

class Aplicacion (

    var id: Int,
    var nombre: String,
    var version: String,
    var descripcion: String,
    var usuarios: ArrayList<Usuario>

    ){
    override fun toString(): String {
        return (ANSI_BLUE +" ${id}\t\t ${nombre}\t\t ${version}\t\t\t ${descripcion}\t\t\t\t ${usuarios}")
    }
}
