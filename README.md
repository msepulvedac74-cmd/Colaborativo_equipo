# Colaborativo_equipo
# Practica2
Alumnos:
Mauricio Sepúlveda C
Ricardo González Z

1 Funciones Matemáticas
 Cálculo de Radio
def CalRadio(area : Double) = { math.sqrt(area /3.1416)}
ejemplo: CalRadio(20)
Evaluacion de Paridad
def esPar (n : Int):Boolean = {
   return n % 2 == 0) }
ejemplo: esPar(4)

2 Manipulación de Strings
Interpolación de Literales
def escribeTweet(tweet: String) = {
  println(s"Estoy escribiendo un $tweet")
}
ejemplo: escribeTweet("tweet")
Extracción de Subcadenas
val mensaje = "Hola Luke yo soy tu padre!"
mensaje slice (5,9)
3 Teoria de Tipos y Mutabilidad
Analisis Conceptural
“val” es un valor, por ejemplo al declarar "val mensaje = "Hola Luke yo soy tu padre!"
 el valor de "mensaje" es esa cadena de caracteres, no cambia.
Por el contrario, cuando se hace uso de "var", se declara una variable que puede cambiar.
por ejemplo n : Int, "n" se le puede asignar cualquier valor.


4 Acceso a Estructuras de Datos (Tuplas)
Indexación de Tuplas
val my_tup = (2,4,5,1,2,3,3.1416,23)
println(my_tup._7)

# Practica3
Alumnos:
Mauricio Sepúlveda C
Ricardo González Z

1 Gestión de Colecciones Inmutables
 Definición inicial
scala> val ListaColores1 = List("rojo","blanco","negro")
val ListaColores1: List[String] = List(rojo, blanco, negro)
Expansión de datos
scala> val ListaColores2 = List("verde","amarillo","azul","naranja","perla")
val ListaColores2: List[String] = List(verde, amarillo, azul, naranja, perla)
Slicing / Filtrado
scala> val seleccionados = ListaColores2.take(3)
val seleccionados: List[String] = List(verde, amarillo, azul)

2 Rangos y Análisis de Conjuntos
Generación de Secuencias
scala> val secuencia = 1 to 1000 by 5
val secuencia: scala.collection.immutable.Range = inexact Range 1 to 1000 by 5
Generación de Secuencias
scala> val arraySecuencia = (1 to 1000 by 5).toArray
val arraySecuencia: Array[Int] = Array(1, 6, 11, 16, 21, 26, 31, 36, 41, 46, 51, 56, 61, 66, 71, 76, 81, 86, 91, 96, 101, 106, 111, 116, 121, 126, 131, 136, 141, 146, 151, 156, 161, 166, 171, 176, 181, 186, 191, 196, 201, 206, 211, 216, 221, 226, 231, 236, 241, 246, 251, 256, 261, 266, 271, 276, 281, 286, 291, 296, 301, 306, 311, 316, 321, 326, 331, 336, 341, 346, 351, 356, 361, 366, 371, 376, 381, 386, 391, 396, 401, 406, 411, 416, 421, 426, 431, 436, 441, 446, 451, 456, 461, 466, 471, 476, 481, 486, 491, 496, 501, 506, 511, 516, 521, 526, 531, 536, 541, 546, 551, 556, 561, 566, 571, 576, 581, 586, 591, 596, 601, 606, 611, 616, 621, 626, 631, 636, 641, 646, 651, 656, 661, 666, 671, 676, 681, 686, 691, 696, 701, 706, 711, 716, 721, 726, 731, 736, 741, 746, 751,...

3 Mapas Mutables y Operaciones de Diccionario
val nombres = scala.collection.mutable.Map(
  "Jose" -> 20,
  "Luis" -> 24,
  "Ana" -> 23,
  "Susana" -> 27
)   

# Practica4
Alumnos:
Mauricio Sepúlveda C
Ricardo González Z

Primera Función – Booleana
La primera función booleana es sencilla y explica cómo definir si el número que se inyecta en la definición es un número par; de ser así, regresará el valor “true”:

def isEven(num:Int): Boolean = {  return num%2 == 0 }

Segunda Función – Es par o non

def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
val l = List(1,2,3,4,5,6,7,8)

En esta función, se puede insertar un listado de números enteros en forma de cadena (string). Despues se ejecuta un “for” para accesar cada uno de los números de la lista y hacer el cálculo, si el número es par se imprime en pantalla “X is even”, y se termina la función, si no es par, continua en la sección “else” en donde si el número no es par se imprime “X is odd”.

Tercera Funcion - Afortunado

def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}

val af= List(1,7,7)
println(afortunado(af))


La función recibe una lista de números. En el “for” se recorre la lista de números y va sumando los numero de la lista y acumulando su valor. La condición es que, si el número de la lista es igual a 7, se le suman 14; para cualquier otro número, se le suma el valor del número y se añade al acumulado.
En el ejemplo la lista es 1, 7, 7; por tanto, la función imprimirá en pantalla los valores: 1, 15 y 29

Tercera Funcion - Balance
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0
    segunda = list.sum
    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)
        if(primera == segunda){
            return true
        }
    }
    return false 
}

val bl = List(3,2,1)
balance(bl)

Esta es una función que busca encontrar un balance en la lista de números que se alimentan a la función, si encuentra balance es “true”, si no arroja “false” como resultado.

Se le alimenta una lista de números. Se crean dos variables que servirán de comparativo. La primer variable es igual a cero, y la segunda es igual a la sumatoria de todos los números. Se utiliza un “for” para recorrer la lista de números. A la primer variable se le van sumando los números de la lista conforme se van recorriendo, en la segunda variable se va restando el valor del número de la lista. Si en algún punto hay balance, se termina la función y devuelve “true”; si recorre todos los números sin encontrar balance, termina y devuelve “false”.








Cuarta Funcion – Palindromo

Un palíndromo es la palabra que tiene el mismo orden de caracteres si se lee al derecho o al revés.

def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO"

println(palindromo(palabra))

En esta función, se alimenta una lista de caracteres. En la variable se utiliza la opción “reverse” para cambiar el orden de los caracteres. Si al cabiar el orden de los caracteres es igual, regresa un valor de true, si por el contrario no es igual, arroja un valor de “false”. En esta función importa si los caracteres son mayúsculas o minúsculas.
