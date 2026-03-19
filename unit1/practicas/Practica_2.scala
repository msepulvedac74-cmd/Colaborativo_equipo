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
