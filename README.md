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

# Practica_Ecaluatoria
# Nota se copio y pego desde la carpeta "Colaborativo_equipo/unit1/practica_evaluatoria/README.txt"

1. Comienza una simple sesión Spark.
-Crea una carpeta para poder clonar la dirección de Git Hub
-Iniciar el CMD dentro de la carpeta
-Utilice el código "spark-shell" y espere unos momentos
spark-shell
2. Cargue el archivo Netflix Stock CSV en un Dataframe llamado df, haga que Spark infiera los tipos de datos.
 ------------ import org.apache.spark.sql.SparkSession  ------------ 
import org.apache.spark.sql.SparkSession
 ------------  val spark = SparkSession.builder().getOrCreate()  ------------ 
val spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.classic.SparkSession@3c36f10b
 ------------  val df = spark.read.option("header","true").option("inferSchema","true").csv("Netflix_2011_2016.csv")  ------------ 
val df: org.apache.spark.sql.DataFrame = [Date: date, Open: double ... 5 more fields]

3. ¿Cuáles son los nombres de las columnas?
df.columns
val res0: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)
df.show()
+----------+-----------------+------------------+----------+-----------------+---------+------------------+
|      Date|             Open|              High|       Low|            Close|   Volume|         Adj Close|
+----------+-----------------+------------------+----------+-----------------+---------+------------------+
|2011-10-24|       119.100002|120.28000300000001|115.100004|       118.839996|120460200|         16.977142|
|2011-10-25|        74.899999|         79.390001| 74.249997|        77.370002|315541800|11.052857000000001|
|2011-10-26|            78.73|         81.420001| 75.399997|        79.400002|148733900|         11.342857|
|2011-10-27|        82.179998| 82.71999699999999| 79.249998|80.86000200000001| 71190000|11.551428999999999|
|2011-10-28|        80.280002|         84.660002| 79.599999|84.14000300000001| 57769600|             12.02|
|2011-10-31|83.63999799999999|         84.090002| 81.450002|        82.080003| 39653600|         11.725715|
|2011-11-01|        80.109998|         80.999998|     78.74|        80.089997| 33016200|         11.441428|
|2011-11-02|        80.709998|         84.400002| 80.109998|        83.389999| 41384000|         11.912857|
|2011-11-03|        84.130003|         92.600003| 81.800003|        92.290003| 94685500|13.184285999999998|
|2011-11-04|91.46999699999999| 92.89000300000001| 87.749999|        90.019998| 84483700|             12.86|
|2011-11-07|             91.0|         93.839998| 89.979997|        90.830003| 47485200|         12.975715|
|2011-11-08|91.22999899999999|         92.600003| 89.650002|        90.470001| 31906000|         12.924286|
|2011-11-09|        89.000001|         90.440001| 87.999998|        88.049999| 28756000|         12.578571|
|2011-11-10|        89.290001| 90.29999699999999| 84.839999|85.11999899999999| 39614400|             12.16|
|2011-11-11|        85.899997|         87.949997|      83.7|        87.749999| 38140200|         12.535714|
|2011-11-14|        87.989998|              88.1|     85.45|        85.719999| 21811300|         12.245714|
|2011-11-15|            85.15|         87.050003| 84.499998|        86.279999| 21372400|         12.325714|
|2011-11-16|        86.460003|         86.460003| 80.890002|        81.180002| 34560400|11.597142999999999|
|2011-11-17|            80.77|         80.999998| 75.789999|        76.460001| 52823400|         10.922857|
|2011-11-18|             76.7|         78.999999| 76.039998|        78.059998| 34729100|         11.151428|
+----------+-----------------+------------------+----------+-----------------+---------+------------------+
only showing top 20 rows

4. ¿Cómo es el esquema?
Al utilizar el commando df.printSchema(), podemos ver el esquema de la tabla y nos muestra que campos contiene y de que tipo de variable
scala> df.printSchema()
root
 |-- Date: date (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)


5. Imprime las primeras 5 renglones.

El commando df.head(5) nos despliega los primeros 5 valores de la tabla

Ejemplo:
scala> df.head(5)
val res2: Array[org.apache.spark.sql.Row] = Array([2011-10-24,119.100002,120.28000300000001,115.100004,118.839996,120460200,16.977142], [2011-10-25,74.899999,79.390001,74.249997,77.370002,315541800,11.052857000000001], [2011-10-26,78.73,81.420001,75.399997,79.400002,148733900,11.342857], [2011-10-27,82.179998,82.71999699999999,79.249998,80.86000200000001,71190000,11.551428999999999], [2011-10-28,80.280002,84.660002,79.599999,84.14000300000001,57769600,12.02])

6. Usa el método describe() para aprender sobre el DataFrame.

El comando df.describe().show() 
scala> df.describe().show() presenta un resumen de cada columna, presentando el numero de fechas, asi como otros datos como valores maximos y minimos. 
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|summary|              Open|              High|               Low|             Close|              Volume|         Adj Close|
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|  count|              1259|              1259|              1259|              1259|                1259|              1259|
|   mean|230.39351086656092|233.97320872915006|226.80127876251044|  230.522453845909|2.5634836060365368E7|55.610540036536875|
| stddev|164.37456353264244| 165.9705082667129| 162.6506358235739|164.40918905512854| 2.306312683388607E7|35.186669331525486|
|    min|         53.990001|         55.480001|             52.81|              53.8|             3531300|          7.685714|
|    max|        708.900017|        716.159996|        697.569984|        707.610001|           315541800|        130.929993|
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+

7. Crea un nuevo Dataframe con una columna nueva llamada “HV Ratio” que es la relación que existe entre el precio de la columna “High” frente a la columna “Volumen” de acciones negociadas por un día. Hint - Es una operación
val df2 = df.withColumn("HV Ratio",df("High")/df("Volume"))
val df2: org.apache.spark.sql.DataFrame = [Date: date, Open: double ... 6 more fields]
df2.show()
+----------+-----------------+------------------+----------+-----------------+---------+------------------+--------------------+
|      Date|             Open|              High|       Low|            Close|   Volume|         Adj Close|            HV Ratio|
+----------+-----------------+------------------+----------+-----------------+---------+------------------+--------------------+
|2011-10-24|       119.100002|120.28000300000001|115.100004|       118.839996|120460200|         16.977142|9.985040951285156E-7|
|2011-10-25|        74.899999|         79.390001| 74.249997|        77.370002|315541800|11.052857000000001|2.515989989281927E-7|
|2011-10-26|            78.73|         81.420001| 75.399997|        79.400002|148733900|         11.342857|5.474206014903126E-7|
|2011-10-27|        82.179998| 82.71999699999999| 79.249998|80.86000200000001| 71190000|11.551428999999999|1.161960907430818...|
|2011-10-28|        80.280002|         84.660002| 79.599999|84.14000300000001| 57769600|             12.02|1.465476686700271...|
|2011-10-31|83.63999799999999|         84.090002| 81.450002|        82.080003| 39653600|         11.725715|2.120614572195210...|
|2011-11-01|        80.109998|         80.999998|     78.74|        80.089997| 33016200|         11.441428|2.453341026526372E-6|
|2011-11-02|        80.709998|         84.400002| 80.109998|        83.389999| 41384000|         11.912857|2.039435578967717E-6|
|2011-11-03|        84.130003|         92.600003| 81.800003|        92.290003| 94685500|13.184285999999998| 9.77974483949496E-7|
|2011-11-04|91.46999699999999| 92.89000300000001| 87.749999|        90.019998| 84483700|             12.86|1.099502069629999...|
|2011-11-07|             91.0|         93.839998| 89.979997|        90.830003| 47485200|         12.975715|1.976194645910725...|
|2011-11-08|91.22999899999999|         92.600003| 89.650002|        90.470001| 31906000|         12.924286|2.902275528113834...|
|2011-11-09|        89.000001|         90.440001| 87.999998|        88.049999| 28756000|         12.578571|3.145082800111281E-6|
|2011-11-10|        89.290001| 90.29999699999999| 84.839999|85.11999899999999| 39614400|             12.16|2.279474054889131E-6|
|2011-11-11|        85.899997|         87.949997|      83.7|        87.749999| 38140200|         12.535714|2.305965805108520...|
|2011-11-14|        87.989998|              88.1|     85.45|        85.719999| 21811300|         12.245714|4.039190694731629...|
|2011-11-15|            85.15|         87.050003| 84.499998|        86.279999| 21372400|         12.325714|4.073010190713256...|
|2011-11-16|        86.460003|         86.460003| 80.890002|        81.180002| 34560400|11.597142999999999|2.501707242971725E-6|
|2011-11-17|            80.77|         80.999998| 75.789999|        76.460001| 52823400|         10.922857|1.533411291208063...|
|2011-11-18|             76.7|         78.999999| 76.039998|        78.059998| 34729100|         11.151428|2.274749388841058...|
+----------+-----------------+------------------+----------+-----------------+---------+------------------+--------------------+
only showing top 20 rows

scala> df2.columns
val res10: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close, HV Ratio)

8. ¿Qué día tuvo el pico más alto en la columna “Open”?
df.orderBy($"High".desc).show(1)
+----------+-----------------+----------+----------+----------+--------+------------------+
|      Date|             Open|      High|       Low|     Close|  Volume|         Adj Close|
+----------+-----------------+----------+----------+----------+--------+------------------+
|2015-07-13|686.6900019999999|716.159996|686.550026|707.610001|33205200|101.08714300000001|
+----------+-----------------+----------+----------+----------+--------+------------------+
only showing top 1 row

9. ¿Cuál es el significado de la columna Cerrar “Close” en el contexto de información financiera, explíquelo no hay que codificar nada?
Close se refiere al valor de las acciones de cierta compañía, es decir, es el valor que le da el mercado a la compañía, (usualmente la bolsa de valores pública), al final de cada día.

10. ¿Cuál es el máximo y mínimo de la columna “Volumen”?

Los commandos "df.select(max("Volume")).show()" y "df.select(min("Volume")).show()" nos permiten obtener el maximo y minimo de la columna volume. Aunque este datos Tambien se desplego con el commando df.describe().show()

scala> df.select(max("Volume")).show()
+-----------+
|max(Volume)|
+-----------+
|  315541800|
+-----------+

scala> df.select(min("Volume")).show()
+-----------+
|min(Volume)|
+-----------+
|    3531300|
+-----------+

11. Con Sintaxis Scala/Spark $ conteste lo siguiente:
a) ¿Cuántos días fue la columna “Close” inferior a $ 600?

El commando "df.filter($"Close"<600).count()" nos muestra que el numero e dias que la coolumna "Close" fue menos a 600 fueron 1218.

scala> df.filter($"Close"<600).count()
val res7: Long = 1218

b) ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
Con el siguiente calculo encontramos que High fue mayor a %00 un 4.92% de las ocasiones.

scala> (df.filter($"High">500).count()*1.0/df.count())*100
val res8: Double = 4.924543288324067

c) ¿Cuál es la correlación de Pearson entre columna “High” y la
columna “Volumen”?

El commando "df.select(corr("High","Volume")).show()" nos despliega la correlacion entre las columnas High y Volumen

scala> df.select(corr("High","Volume")).show()
+--------------------+
|  corr(High, Volume)|
+--------------------+
|-0.20960233287942157|
+--------------------+

d) ¿Cuál es el máximo de la columna “High” por año?

Este proceso es mas complejo ya que require crear variables para obtener el año de la fecha, y filtrar el maximo de cada año.

scala> val yeardf = df.withColumn("Year",year(df("Date")))
val yeardf: org.apache.spark.sql.DataFrame = [Date: date, Open: double ... 6 more fields]

scala> val yearmaxs = yeardf.select($"Year",$"High").groupBy("Year").max()
val yearmaxs: org.apache.spark.sql.DataFrame = [Year: int, max(Year): int ... 1 more field]

scala>

scala> yearmaxs.select($"Year",$"max(High)").show()
+----+------------------+
|Year|         max(High)|
+----+------------------+
|2015|        716.159996|
|2013|        389.159988|
|2014|        489.290024|
|2012|        133.429996|
|2016|129.28999299999998|
|2011|120.28000300000001|
+----+------------------+



e) ¿Cuál es el promedio de la columna “Close” para cada mes del calendario?

Este ejercicio tambien es complejo para extraer el mes de la fecha y hacer una sumatoria y obtener el promedio.

scala> val monthdf = df.withColumn("Month",month(df("Date")))
val monthdf: org.apache.spark.sql.DataFrame = [Date: date, Open: double ... 6 more fields]

scala> val monthavgs = monthdf.select($"Month",$"Close").groupBy("Month").mean()
val monthavgs: org.apache.spark.sql.DataFrame = [Month: int, avg(Month): double ... 1 more field]

scala> monthavgs.select($"Month",$"avg(Close)").show()
+-----+------------------+
|Month|        avg(Close)|
+-----+------------------+
|   12| 199.3700942358491|
|    1|212.22613874257422|
|    6| 295.1597153490566|
|    3| 249.5825228971963|
|    5|264.37037614150944|
|    9|206.09598121568627|
|    4|246.97514271428562|
|    8|195.25599892727263|
|    7|243.64747528037387|
|   10|205.93297300900903|
|   11| 194.3172275445545|
|    2| 254.1954634020619|
+-----+------------------+

# Práctica 2 - Regresión Logística

scala> import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.classification.LogisticRegression

scala> import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession

scala> import org.apache.log4j._
import org.apache.log4j._

scala> Logger.getLogger("org").setLevel(Level.ERROR)

scala> val spark = SparkSession.builder().getOrCreate()
val spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.classic.SparkSession@51e55964

scala> val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv"
)
val data: org.apache.spark.sql.DataFrame = [Daily Time Spent on Site: double, Age: int ... 8 more fields]

scala> data.printSchema()
root
 |-- Daily Time Spent on Site: double (nullable = true)
 |-- Age: integer (nullable = true)
 |-- Area Income: double (nullable = true)
 |-- Daily Internet Usage: double (nullable = true)
 |-- Ad Topic Line: string (nullable = true)
 |-- City: string (nullable = true)
 |-- Male: integer (nullable = true)
 |-- Country: string (nullable = true)
 |-- Timestamp: timestamp (nullable = true)
 |-- Clicked on Ad: integer (nullable = true)


scala> data.head(1)
val res2: Array[org.apache.spark.sql.Row] = Array([68.95,35,61833.9,256.09,Cloned 5thgeneration orchestration,Wrightburgh,0,Tunisia,2016-03-27 00:53:11.0,0])

scala> data.head(20)
val res3: Array[org.apache.spark.sql.Row] = Array([68.95,35,61833.9,256.09,Cloned 5thgeneration orchestration,Wrightburgh,0,Tunisia,2016-03-27 00:53:11.0,0], [80.23,31,68441.85,193.77,Monitored national standardization,West Jodi,1,Nauru,2016-04-04 01:39:02.0,0], [69.47,26,59785.94,236.5,Organic bottom-line service-desk,Davidton,0,San Marino,2016-03-13 20:35:42.0,0], [74.15,29,54806.18,245.89,Triple-buffered reciprocal time-frame,West Terrifurt,1,Italy,2016-01-10 02:31:19.0,0], [68.37,35,73889.99,225.58,Robust logistical utilization,South Manuel,0,Iceland,2016-06-03 03:36:18.0,0], [59.99,23,59761.56,226.74,Sharable client-driven software,Jamieberg,1,Norway,2016-05-19 14:30:17.0,0], [88.91,33,53852.85,208.36,Enhanced dedicated support,Brandonstad,0,Myanmar,2016-0...

scala> val colnames = data.columns
val colnames: Array[String] = Array(Daily Time Spent on Site, Age, Area Income, Daily Internet Usage, Ad Topic Line, City, Male, Country, Timestamp, Clicked on Ad)

scala> val firstrow = data.head(1)(0)
val firstrow: org.apache.spark.sql.Row = [68.95,35,61833.9,256.09,Cloned 5thgeneration orchestration,Wrightburgh,0,Tunisia,2016-03-27 00:53:11.0,0]

scala> println("\n")



scala> println("Example data row")
Example data row

scala> for(ind <- Range(1, colnames.length)){
     |     println(colnames(ind))
     |     println(firstrow(ind))
     |     println("\n")
     | }
Age
35


Area Income
61833.9


Daily Internet Usage
256.09


Ad Topic Line
Cloned 5thgeneration orchestration


City
Wrightburgh


Male
0


Country
Tunisia


Timestamp
2016-03-27 00:53:11.0


Clicked on Ad
0



scala> val timedata = data.withColumn("Hour",hour(data("Timestamp")))
val timedata: org.apache.spark.sql.DataFrame = [Daily Time Spent on Site: double, Age: int ... 9 more fields]

scala> val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area I
ncome", $"Daily Internet Usage", $"Hour", $"Male")
val logregdata: org.apache.spark.sql.DataFrame = [label: int, Daily Time Spent on Site: double ... 5 more fields]

scala> import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.VectorAssembler

scala> import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.linalg.Vectors

scala> val assembler = (new VectorAssembler()
     | .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
     | .setOutputCol("features"))
val assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_247c1b440d86, handleInvalid=error, numInputCols=6

scala> val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)
val training: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: int, Daily Time Spent on Site: double ... 5 more fields]
val test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: int, Daily Time Spent on Site: double ... 5 more fields]

scala> import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.Pipeline

scala> val lr = new LogisticRegression()
val lr: org.apache.spark.ml.classification.LogisticRegression = logreg_1a4d5e95f875

scala> val pipeline = new Pipeline().setStages(Array(assembler, lr))
val pipeline: org.apache.spark.ml.Pipeline = pipeline_9e5b005e1117

scala> val model = pipeline.fit(training)
26/05/18 20:02:56 WARN InstanceBuilder: Failed to load implementation from:dev.ludovic.netlib.blas.JNIBLAS
val model: org.apache.spark.ml.PipelineModel = pipeline_9e5b005e1117

scala> val results = model.transform(test)
val results: org.apache.spark.sql.DataFrame = [label: int, Daily Time Spent on Site: double ... 9 more fields]

scala> val results = model.transform(test)
val results: org.apache.spark.sql.DataFrame = [label: int, Daily Time Spent on Site: double ... 9 more fields]

scala> import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.evaluation.MulticlassMetrics

scala> val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val predictionAndLabels: org.apache.spark.rdd.RDD[(Double, Double)] = MapPartitionsRDD[72] at rdd at <console>:1

scala> val metrics = new MulticlassMetrics(predictionAndLabels)
val metrics: org.apache.spark.mllib.evaluation.MulticlassMetrics = org.apache.spark.mllib.evaluation.MulticlassMetrics@63e36572

scala> println("Confusion matrix:")
Confusion matrix:

scala> println(metrics.confusionMatrix)
136.0  1.0
4.0    146.0

scala> metrics.accuracy
val res9: Double = 0.9825783972125436

scala>
