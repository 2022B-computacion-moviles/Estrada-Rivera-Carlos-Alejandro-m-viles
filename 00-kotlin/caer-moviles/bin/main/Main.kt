fun main(args: Array<String>) {
    println("Hello World!")

    // Tipos de variables
    // variables Inmutables (no se pueden reasignar)

    val inmutable: String = "String";
    //inmutable = "Example";

    //Variables Mutables
    var mutable: String = "Vicente";
    mutable = "Adrian";

    //Duck Typing

    val ejemploVariable = "Ejemplo"

    ejemploVariable.trim()

    val edad = 12

    //Variables primitivas
    val NombreProf: String = "Adrian"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val mayoredad = true

    //Clases
    //val fechaNacimiento: Date = Date() // sin new


    //switch no existe
    val estadoCivilWhen = 'S'

    when (estadoCivilWhen){
        ('S')-> {
            println("Soltero")
        }
        ('C')->println("Casado")
        else -> println("Desconocido")
    }
    val coqueto = if(estadoCivilWhen == 'S') "Si" else "No"

    val SumaUno = Suma(1,2)
    val SumaDos = Suma(1,null)
    val SumaTres = Suma (null,2)
    val SumaCuatro = Suma(null,null)

    SumaUno.sumar()
    SumaDos.sumar()
    SumaTres.Sumar()
    SumaCuatro.Sumar()
    println(Suma.historialSumas)


    //ARREGLOS

    //tipos de Arreglos

    //Arreglo Estático
    val arregloEstatico: Array<Int> = arrayOf(1,2,3)
    println(arregloEstatico)

    //Arreglo Dinámico
    val arregloDinamico: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // OPERADORES-> Sirven para arreglos estáticos y dinpamicos
    // FOR EACH -> Unit
    //Iterar un Arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach{
            valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    arregloEstatico
        .forEachIndexed {
            indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }
    println(respuestaForEach)

    // MAP

    val resouestaMap:List<Double> = arregloDinamico
        .map{
            valorActual: Int->
            return@map valorActual.toDouble() + 100.00
        }
    println(resouestaMap)
    val respuestaMapDos = arregloDinamico.map {it +15}
    println(respuestaMapDos)



    //FILTER->FILTRAR EL ARREGLO
    // 1) Devolver expresion
    // 2) Nuevo arreglo filtrado

    val respuestaFilter: List<Int> = arregloDinamico
        .filter {
            valorActual: Int->
            val mayoresACinco: Boolean = valorActual > 5
            return@filter mayoresACinco
        }

    val respuestaFilterDos = arregloDinamico.filter{it >=5 }
    println(respuestaFilter)
    println(respuestaFilterDos )


    //OR AND
    // OR-> ANY (alguno cumple?)
    // AND -> (Todos cumplen?)

    val respuestaAny: Boolean = arregloDinamico
        .any{
            valorActual: Int ->
            return@any (valorActual>5)
        }
    println(respuestaAny)
    val resouestaAll: Boolean = arregloDinamico
        .all{
            valorActual: Int ->
            return@all (valorActual>5)
        }
    println(resouestaAll)


    //REDUCE-> valor acumulado
    // Valor acumulado = 0 (Siempre 0 en lenguaje kotlin)


    val respuestaReduce: Int = arregloDinamico
        .reduce{
            acumulado: Int, valorActual: Int->
            return@reduce (acumulado + valorActual)
        }
    println(respuestaReduce)

    //Funciones

    fun imprimirNombre (nombre: String): Unit{
        println("Nombre: ${nombre}")

    }

    fun calcularSueldo(
        sueldo: Double,
        tasa: Double = 12.00,
        bonoEspecial: Double? = null
    ):Double{

        if (bonoEspecial!=null) {
            return sueldo * tasa * bonoEspecial
        }
        return sueldo * tasa
    }

    abstract class NumerosJava{
        protected val numeroUno: Int
        private val NumeroDos: Int

        constructor(
            uno: Int,
            dos :Int
        ){
            this.numeroUno=uno;
            this.NumeroDos=dos;
            println("inciando")
        }
    }

    abstract class Numeros(
        //constructor primario
        // uno: Int //Parametro
        // public var uno: Int, //Propiedad de la clase publica

        protected val numeroUno: Int,// Propiedad
        protected val numeroDos: Int //Propiedad
    ){
        init {
            //Bloque de codigo del constructor primario
            // this.numeroDos // "this" opcional
            numeroUno
            numeroDos
            println("Inciando")
        }
    }


    //HERENCIA

    class Suma (
        //Constructor primario suma
    uno: Int,
    dos: Int,
    ): Numeros (
        //Hereda de la clase Numeros
        //Super Constructor numeros
        uno,
        dos,
            ){
        init {
            //Bloque Constructor primario
            this.numeroUno
            this.numeroDos
        }
        constructor (//Segundo Constructor
            uno: Int?,
            dos: Int
                ): this(
                    if (uno == null) 0 else uno,
                    dos
                ){}
        constructor (//Tercer Constructor
            uno: Int,
            dos: Int?
        ): this(
            if (dos == null) 0 else dos,
            uno
        ){}
        constructor (//Cuarto Constructor
            uno: Int?,
            dos: Int?
        ): this(
            if (uno == null) 0 else uno,
            if (dos == null) 0 else dos
        ){}

        fun sumar(): Int{

            val total = numeroUno + numeroDos
            agregarHistorial(total)
            return total
        }

        companion object{
            val pi = 3.14 //Suma.pi -> 3.14
            val historialSuma = arrayListOf<Int>()
            fun agregarHistorial(valorNuevaSuma: Int){
                historialSuma.add(valorNuevaSuma)
            }
        }
    }


}