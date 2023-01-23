import java.io.BufferedReader
import java.io.InputStreamReader


val ROOT = "/home/carlos/Documentos/Semestre 2022-B/CRUD_Exam/src/"

//Lector de CMD
val input = BufferedReader(InputStreamReader(System.`in`))

// Console Colors
val ANSI_RESET: String? = "\u001B[0m"
const val ANSI_BLACK = "\u001B[30m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_GREEN = "\u001B[32m"
const val ANSI_LIGHT_YELLOW = "\u001B[93m"
const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_YELLOW_BACKGROUND = "\u001B[43m"
const val ANSI_BLUE = "\u001B[34m"
const val ANSI_PURPLE = "\u001B[35m"
const val ANSI_CYAN = "\u001B[36m"
const val ANSI_WHITE = "\u001B[37m"
const val ANSI_BOLD = "\u001B[1m"
const val ANSI_UNBOLD = "\u001B[21m"
const val ANSI_UNDERLINE = "\u001B[4m"
const val ANSI_STOP_UNDERLINE = "\u001B[24m"
const val ANSI_BLINK = "\u001B[5m"
// Resets previous color codes
const val reset = "\u001b[0m"

fun main(args: Array<String>) {

    Banner()
    MenuPrincipal()

}

// Banner Presentation Fun

fun Banner(){
    print( ANSI_BLUE +"\n" +
            " ██████╗██████╗ ██╗   ██╗██████╗     ██╗  ██╗ ██████╗ ████████╗██╗     ██╗███╗   ██╗\n" +
            "██╔════╝██╔══██╗██║   ██║██╔══██╗    ██║ ██╔╝██╔═══██╗╚══██╔══╝██║     ██║████╗  ██║\n" +
            "██║     ██████╔╝██║   ██║██║  ██║    █████╔╝ ██║   ██║   ██║   ██║     ██║██╔██╗ ██║\n" +
            ANSI_CYAN+"██║     ██╔══██╗██║   ██║██║  ██║    ██╔═██╗ ██║   ██║   ██║   ██║     ██║██║╚██╗██║\n" +
            "╚██████╗██║  ██║╚██████╔╝██████╔╝    ██║  ██╗╚██████╔╝   ██║   ███████╗██║██║ ╚████║\n" +
            " ╚═════╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝     ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝╚═╝╚═╝  ╚═══╝\n" +
            "                                                                                  " + ANSI_BOLD + ANSI_RED + "[by Linkcar13]\n" + reset)
}

// Menu Principal

fun MenuPrincipal(){

    print(ANSI_LIGHT_YELLOW+"\n" +
            "___ ____ ___  _    ____ ____    _  _ ____ _  _ _  _\n" +
            " |  |__| |__] |    |___ [__     |\\/| |___ |\\ | |  |\n" +
            " |  |  | |__] |___ |___ ___]    |  | |___ | \\| |__|\n" +
            reset)
    print(ANSI_GREEN + "1) Visualizar Tabla Aplicaciones\n"+
         ANSI_CYAN + "2) Visulizar Tabla Usuarios\n" +
            ANSI_RED+ "3) Salir\n" +reset)

    var option_menu_principal = input.readLine().toInt()

    if (option_menu_principal == 1) {

        coremostrarAplicaciones()
        MenuCrud(1)
    }
    else if(option_menu_principal == 2){
        coremostrarUsuarios()
        MenuCrud(2)
    }else if (option_menu_principal == 3){
        System.exit(0)
    }

}

//función para mostrar tablas
fun MostrarTablas(tabla: Int){




    MenuCrud(tabla)
}

//Función para mostrar el menu crud en la tabla actual
fun MenuCrud (tabla: Int){


    print(ANSI_PURPLE + "\n" +
            "____ ____ _  _ ___     ____ ___  ____ ____ ____ ___ _ ____ _  _ ____\n" +
            "|    |__/ |  | |  \\    |  | |__] |___ |__/ |__|  |  | |  | |\\ | [__ \n" +
            "|___ |  \\ |__| |__/    |__| |    |___ |  \\ |  |  |  | |__| | \\| ___]\n" + reset)
    print(ANSI_GREEN+"1) Crear Registro\n"+reset)
    print(ANSI_BLUE+"2) Actualizar Registro\n"+reset)
    print(ANSI_RED + "3) Eliminar Registro\n" + reset)
    print(ANSI_PURPLE + "4) Volver\n"+reset)
    var opcion_crud = input.readLine().toInt()

    if (opcion_crud == 1){
        if (tabla == 1){
            coreCrearAplicacion()
        }else if(tabla == 2){
            coreCrearUsuario()
        }
    }else if (opcion_crud == 2){
        if (tabla == 1){
            coreModificarAplicacion()
        }else if(tabla == 2){
            coreModificarUsuario()
        }
    }else if (opcion_crud == 3){
        if (tabla == 1){
            coreEliminarAplicacion()
        }else if(tabla == 2){
            coreEliminarUsuario()
        }
    }
    else if (opcion_crud == 4){
        MenuPrincipal()
    }
}