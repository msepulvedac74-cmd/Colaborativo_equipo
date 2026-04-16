#Practica_Ecaluatoria
#Instrucciones: Responder las siguientes preguntas con Spark DataFrames y Scala utilizando el “CSV” Netflix_2011_2016.csv que se encuentra en la carpeta de spark-dataframes. No utilicé inteligencia artificial para resolver esta practica, use el código base que el profesor proporciono.

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
5. Imprime las primeras 5 renglones.
6. Usa el método describe() para aprender sobre el DataFrame.
7. Crea un nuevo Dataframe con una columna nueva llamada “HV Ratio” que es
la relación que existe entre el precio de la columna “High” frente a la
columna “Volumen” de acciones negociadas por un día. Hint - Es una operación
8. ¿Qué día tuvo el pico más alto en la columna “Open”?
9. ¿Cuál es el significado de la columna Cerrar “Close” en el contexto de
información financiera, explíquelo no hay que codificar nada?
10. ¿Cuál es el máximo y mínimo de la columna “Volumen”?
11. Con Sintaxis Scala/Spark $ conteste lo siguiente:
a) ¿Cuántos días fue la columna “Close” inferior a $ 600?
b) ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
c) ¿Cuál es la correlación de Pearson entre columna “High” y la
columna “Volumen”?
d) ¿Cuál es el máximo de la columna “High” por año?
