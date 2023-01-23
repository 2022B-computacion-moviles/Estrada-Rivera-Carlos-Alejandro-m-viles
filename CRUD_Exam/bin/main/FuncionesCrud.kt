import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader
import java.io.FileWriter

//Cabeceras Tablas

const val TablaApps = "ID\t\t Nombre\t\t Version\t\t Descripcion\t\t\t\t\t\t\tUsuario(s)\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
const val TablaUsers = "ID\t\t ID_APP\t Nombre\t\t Apellido\t\t Correo\t\t\t\t Genero"


//Funciones de Archivos Tablas

var gson: Gson = Gson()

fun BaseDeDatos (tabla: Int): File {
    var nombretabla = ""
    if (tabla == 1){
        nombretabla = "Aplicaciones"
    }else if(tabla == 2){
        nombretabla = "Usuarios"
    }

    val archivo: File = File(ROOT+"archivos/Tabla"+ nombretabla + ".json")

    return archivo
}

fun crearArchivo(tabla :  Int) {
    var archivo = BaseDeDatos(tabla)
    FileWriter(archivo).use { it.write("") }
}



//Aplicaciones
fun mostrarAplicaciones(): ArrayList<Aplicacion>{

    var archivo = BaseDeDatos(1)
    var Aplicaciones = arrayListOf<Aplicacion>()
    if (archivo.exists()) {
        val input = FileReader(archivo).use {
            it.readText()
        }
        if(input == ""){
            Aplicaciones = arrayListOf<Aplicacion>()
        }else{
            val tipoClase = object : TypeToken<ArrayList<Aplicacion>>() {}.type
            var JSONAplicaciones: ArrayList<Aplicacion> = gson.fromJson(input, tipoClase)
            Aplicaciones = JSONAplicaciones
        }
    }
    else {
        Aplicaciones = arrayListOf<Aplicacion>()
    }

    return Aplicaciones
}

fun coremostrarAplicaciones( ){
    val Aplicaciones = mostrarAplicaciones()
    print(ANSI_YELLOW_BACKGROUND+ANSI_BLINK + TablaApps + reset)
    for(app in Aplicaciones){
        print("\n" + app.toString() + "\n")
    }
}

fun CrearAplicacion(app: Aplicacion){

    var archivo = BaseDeDatos(1)
    if (archivo.exists()) {
        val jsonInput = FileReader(archivo).use {
            it.readText()
        }

        if (jsonInput == "") {
            //println("Archivo Vacío")
            var aplicaciones= arrayListOf<Aplicacion>(app)
            val newJSON = gson.toJson(aplicaciones)

            FileWriter(archivo).use {
                it.write(newJSON, 0, newJSON.length)
            }
        } else {
            val tipoClase = object : TypeToken<ArrayList<Aplicacion>>() {}.type
            val aplicaciones: ArrayList<Aplicacion> = gson.fromJson(jsonInput, tipoClase)
            aplicaciones.add(app)
            val newJSON = gson.toJson(aplicaciones)

            FileWriter(archivo).use {
                it.write(newJSON, 0, newJSON.length)
            }
        }
    }
    else{
        crearArchivo(1)
        var PlayStores= arrayListOf<Aplicacion>(app)
        val newJSON = gson.toJson(PlayStores)

        FileWriter(archivo).use {
            it.write(newJSON, 0, newJSON.length)
        }
    }

    print(ANSI_GREEN +"Aplicacion Creada con exito\n"+ANSI_RESET)
}

fun coreCrearAplicacion(){
    var anadirus = "N"

    var usuarios = arrayListOf <Usuario> ()
    print(ANSI_PURPLE+"Ingrese los Datos de la Aplicacion\n"+ANSI_RESET)
    print(ANSI_BLUE+"Ingrese el id de la aplicacion\n"+ANSI_RESET)
    var idApp = input.readLine().toInt()
    print(ANSI_BLUE+"Ingrese el nombre de la aplicacion\n"+ANSI_RESET)
    var nombreApp = input.readLine().toString()
    print(ANSI_BLUE+"Ingrese la Version de la aplicacion\n"+ANSI_RESET)
    var versionApp = input.readLine().toString()
    print(ANSI_BLUE+"Ingrese una Descripcion de la aplicacion\n"+ANSI_RESET)
    var descripcionApp = input.readLine().toString()
    print(ANSI_YELLOW+"Ingrese usuarios a la Aplicación\n"+ANSI_RESET)
    do {
        print(ANSI_BLUE+"Ingrese el id del Usuario\n"+ANSI_RESET)
        var idus = input.readLine().toInt()
        print(ANSI_BLUE+"Ingrese el nombre del Usuario\n"+ANSI_RESET)
        var nombreus = input.readLine().toString()
        print(ANSI_BLUE+"Ingrese el apellido del Usuario\n"+ANSI_RESET)
        var apellidous = input.readLine().toString()
        print(ANSI_BLUE+"Ingrese el correo del Usuario\n"+ANSI_RESET)
        var correous = input.readLine().toString()
        print(ANSI_BLUE+"Ingrese la fecha de nacimiento del Usuario\n"+ANSI_RESET)
        var fechaus = input.readLine().toString()
        print(ANSI_BLUE+"Ingrese el genero del Usuario\n"+ANSI_RESET)
        var generous = input.readLine().toString()
        usuarios.add(Usuario(idus,idApp,nombreus,apellidous,correous,fechaus,generous))
        CrearUsuarioDesdeAplicacion(Usuario(idus,idApp,nombreus,apellidous,correous,fechaus,generous))
        //print(ANSI_GREEN+"Usuario Añadido correctamente \n"+ANSI_RESET)
        print(ANSI_RED+"Terminar S/N \n"+ANSI_RESET)
        anadirus = input.readLine().toString()
    }while (anadirus == "N")
    CrearAplicacion(Aplicacion(idApp,nombreApp,versionApp,descripcionApp,usuarios))
    if( anadirus == "S"){
        coremostrarAplicaciones()
        MenuCrud(1)
    }
}


fun ModificarAplicacion(PlayStore:ArrayList<Aplicacion>){

    var archivo = BaseDeDatos(1)
    val json = gson.toJson(PlayStore)

    FileWriter(archivo).use {
        it.write(json, 0, json.length)
    }

    println(ANSI_GREEN+"Tabla Modificada\n" + ANSI_RESET)
}



fun coreModificarAplicacion(){
    var UpdateAPlicacion = "S"
    var UpdateAtributo = ""
    val apps = mostrarAplicaciones()
    while(UpdateAPlicacion == "S") {

        print(ANSI_CYAN+"Ingrese el ID de la Aplicacion a actualizar: " + ANSI_RESET)
        var idaux : Int = input.readLine().toInt()
        if (apps.any { it.id == idaux }) {
            var Temp = apps.filter { it.id == idaux }.firstOrNull()
                print(ANSI_YELLOW+"Desea modificar el atributo nombre de la aplicacion? $/N\n")
                UpdateAtributo = input.readLine().toString()
            if (UpdateAtributo == "S") {
                print(ANSI_CYAN + "Ingrese el nuevo nombre de la aplicacion:\n" + reset)
                Temp!!.nombre = input.readLine().toString()
            }
            print(ANSI_YELLOW+"Desea modificar el atributo Version de la aplicacion? $/N\n")
            UpdateAtributo = input.readLine().toString()
            if (UpdateAtributo == "S") {
                print(ANSI_CYAN + "Ingrese la nueva Version de la Alicacion:\n" + reset)
                Temp!!.version = input.readLine().toString()
            }
            print(ANSI_YELLOW+"Desea modificar el atributo descripcion de la aplicacion? $/N\n")
            UpdateAtributo = input.readLine().toString()
            if (UpdateAtributo == "S") {
                print("Ingrese una nueva Descripcion para la app: ")
                Temp!!.descripcion = input.readLine().toString()
            }
            var AplicacionBefore = apps.filter { it.id == idaux }.firstOrNull()
            val AplicacionAfter = apps.indexOf(AplicacionBefore)
            if (AplicacionAfter > 0){
                apps.set(AplicacionAfter, Temp!!)
            }
            ModificarAplicacion(apps)
            coremostrarAplicaciones()
            MenuCrud(1)
        }
        else {
            println(ANSI_RED+"Ingrese un ID Valido"+reset)
        }
        MenuCrud(1)
    }
}
fun coreEliminarAplicacion(){

    var BorrarAplicacion = "S"
    val apps = mostrarAplicaciones()
    print(ANSI_RED+"Ingrese el ID de la Aplicación a eliminar: \n")
    var idAux = input.readLine().toInt()
    if (idAux > 0) {
        var SprAplicacion = apps.filter { it.id == idAux }.firstOrNull()
        val Borrar = apps.indexOf(SprAplicacion)
        if (Borrar > 0){
            apps.removeAt(Borrar)
            ModificarAplicacion(apps)
        }
    }
    print(ANSI_GREEN + "\nEsgistro Eliminado con Exito\n")
    coremostrarAplicaciones()
    MenuCrud(1)
}
//___________________________________________________________________________________________________________________________________________________//
//___________________________________________________________________________________________________________________________________________________//
//___________________________________________________________________________________________________________________________________________________//
//USUARIOS
fun mostrarUsuarios(): ArrayList<Usuario>{
    var archivo = BaseDeDatos(2)
    var Usuarios = arrayListOf<Usuario>()
    if (archivo.exists()) {
        val input = FileReader(archivo).use {
            it.readText()
        }
        if(input == ""){
            Usuarios = arrayListOf<Usuario>()
        }else{
            val tipoClase = object : TypeToken<ArrayList<Usuario>>() {}.type
            var JSONUsuarios: ArrayList<Usuario> = gson.fromJson(input, tipoClase)
            Usuarios = JSONUsuarios
        }
    }
    else {
        Usuarios = arrayListOf<Usuario>()
    }
    return Usuarios
}

fun coremostrarUsuarios( ){
    val Users = mostrarUsuarios()
    print(ANSI_YELLOW_BACKGROUND+ANSI_BLINK + ANSI_BOLD + TablaUsers + reset)
    for(user in Users){
        print("\n"+user.toString()+"\n")
    }
}

fun CrearUsuario(user: Usuario){

    var archivo = BaseDeDatos(2)
    if (archivo.exists()) {
        val jsonInput = FileReader(archivo).use {
            it.readText()
        }

        if (jsonInput == "") {
            //println("Archivo Vacío")
            var aplicaciones= arrayListOf<Usuario>(user)
            val newJSON = gson.toJson(aplicaciones)

            FileWriter(archivo).use {
                it.write(newJSON, 0, newJSON.length)
            }
        } else {
            val tipoClase = object : TypeToken<ArrayList<Usuario>>() {}.type
            val aplicaciones: ArrayList<Usuario> = gson.fromJson(jsonInput, tipoClase)
            aplicaciones.add(user)
            val newJSON = gson.toJson(aplicaciones)

            FileWriter(archivo).use {
                it.write(newJSON, 0, newJSON.length)
            }
        }
    }
    else{
        crearArchivo(1)
        var Users= arrayListOf<Usuario>(user)
        val newJSON = gson.toJson(Users)

        FileWriter(archivo).use {
            it.write(newJSON, 0, newJSON.length)
        }
    }

    print(ANSI_GREEN +"Usuario Creado con exito\n"+ reset)
    coremostrarUsuarios()
    MenuCrud(2)
}
fun CrearUsuarioDesdeAplicacion(user: Usuario){

    var archivo = BaseDeDatos(2)
    if (archivo.exists()) {
        val jsonInput = FileReader(archivo).use {
            it.readText()
        }

        if (jsonInput == "") {
            //println("Archivo Vacío")
            var aplicaciones= arrayListOf<Usuario>(user)
            val newJSON = gson.toJson(aplicaciones)

            FileWriter(archivo).use {
                it.write(newJSON, 0, newJSON.length)
            }
        } else {
            val tipoClase = object : TypeToken<ArrayList<Usuario>>() {}.type
            val aplicaciones: ArrayList<Usuario> = gson.fromJson(jsonInput, tipoClase)
            aplicaciones.add(user)
            val newJSON = gson.toJson(aplicaciones)

            FileWriter(archivo).use {
                it.write(newJSON, 0, newJSON.length)
            }
        }
    }
    else{
        crearArchivo(1)
        var Users= arrayListOf<Usuario>(user)
        val newJSON = gson.toJson(Users)

        FileWriter(archivo).use {
            it.write(newJSON, 0, newJSON.length)
        }
    }

    print(ANSI_GREEN +"Usuario Creado con exito\n"+ reset)
    //coremostrarUsuarios()
    //MenuCrud(2)
}

fun coreCrearUsuario(){

    print(ANSI_PURPLE+"Ingrese los Datos del Usuario\n"+ANSI_RESET)
    print(ANSI_BLUE+"Ingrese el id del Usuario\n"+ANSI_RESET)
    var idus = input.readLine().toInt()
    print(ANSI_BLUE+"Ingrese el id de la Aplicacion\n"+ANSI_RESET)
    var idApp = input.readLine().toInt()
    print(ANSI_BLUE+"Ingrese el nombre del Usuario\n"+ANSI_RESET)
    var nombreus = input.readLine().toString()
    print(ANSI_BLUE+"Ingrese el apellido del Usuario\n"+ANSI_RESET)
    var apellidous = input.readLine().toString()
    print(ANSI_BLUE+"Ingrese el correo del Usuario\n"+ANSI_RESET)
    var correous = input.readLine().toString()
    print(ANSI_BLUE+"Ingrese la fecha de nacimiento del Usuario\n"+ANSI_RESET)
    var fechaus = input.readLine().toString()
    print(ANSI_BLUE+"Ingrese el genero del Usuario\n"+ANSI_RESET)
    var generous = input.readLine().toString()

    CrearUsuario(Usuario(idus,idApp,nombreus,apellidous,correous,fechaus,generous))

}


fun ModificarUsuario(Users:ArrayList<Usuario>){
    var archivo = BaseDeDatos(2)
    val json = gson.toJson(Users)

    FileWriter(archivo).use {
        it.write(json, 0, json.length)
    }

    println(ANSI_GREEN+"Tabla Modificada\n" + ANSI_RESET)
}

fun coreModificarUsuario(){
    var UpdateAPlicacion = "S"
    var UpdateAtributo = ""
    while(UpdateAPlicacion == "S") {
        val users = mostrarUsuarios()
        print(ANSI_CYAN+"Ingrese el ID del Usuario a actualizar: " + ANSI_RESET)
        var idaux : Int = input.readLine().toInt()
        if (users.any { it.id == idaux }) {
            var Temp = users.filter { it.id == idaux }.firstOrNull()
            print(ANSI_YELLOW+"Desea modificar el atributo id de la aplicacion para el usuario? $/N\n")
            UpdateAtributo = input.readLine().toString()
            if (UpdateAtributo == "S") {
                print(ANSI_CYAN + "Ingrese el nuevo id de de la aplicacion para el usuario:\n" + reset)
                Temp!!.idAplicacion = input.readLine().toInt()
            }
            print(ANSI_YELLOW+"Desea modificar el atributo Nombre del Usuario? $/N\n")
            UpdateAtributo = input.readLine().toString()
            if (UpdateAtributo == "S") {
                print(ANSI_CYAN + "Ingrese el nuevo Nombre del usuario:\n" + reset)
                Temp!!.nombre = input.readLine().toString()
            }
            print(ANSI_YELLOW+"Desea modificar el atributo Apellido del Usuario? $/N\n")
            UpdateAtributo = input.readLine().toString()
            if (UpdateAtributo == "S") {
                print(ANSI_CYAN + "Ingrese el nuevo Apellido del Usuario\n" + reset)
                Temp!!.apellido = input.readLine().toString()
            }
            print(ANSI_YELLOW+"Desea modificar el atributo correo del Usuario? $/N\n")
            UpdateAtributo = input.readLine().toString()
            if (UpdateAtributo == "S") {
                print("Ingrese un nuevo correo para el usuario: ")
                Temp!!.correo = input.readLine().toString()
            }
            var AplicacionBefore = users.filter { it.id == idaux }.firstOrNull()
            val AplicacionAfter = users.indexOf(AplicacionBefore)
            if (AplicacionAfter > 0){
                users.set(AplicacionAfter, Temp!!)
            }
            ModificarUsuario(users)
            coremostrarUsuarios()
            MenuCrud(2)
        }
        else {
            println(ANSI_RED + "Ingrese un ID Valido" + reset)
        }
        MenuCrud(2)
    }
}
fun coreEliminarUsuario(){

    val users = mostrarUsuarios()
    print(ANSI_RED+"Ingrese el ID del Usuario a eliminar: \n")
    var idAux = input.readLine().toInt()
    if (idAux > 0) {
        var SprUsuario = users.filter { it.id == idAux }.firstOrNull()
        val Borrar = users.indexOf(SprUsuario)
        if (Borrar > 0){
            users.removeAt(Borrar)
            ModificarUsuario(users)
        }
    }
    print(ANSI_GREEN + "\nEsgistro Eliminado con Exito\n")
    coremostrarUsuarios()
    MenuCrud(2)
}

