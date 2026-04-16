Instrucciones
Responder las siguientes preguntas con Spark DataFrames y Scala utilizando el “CSV”
Netflix_2011_2016.csv que se encuentra en la carpeta de spark-dataframes.
No utilicé inteligencia artificial para resolver esta practica, use el código base que el
profesor proporciono.
1. Comienza una simple sesión Spark.
2. Cargue el archivo Netflix Stock CSV en un Dataframe llamado df, haga
que Spark infiera los tipos de datos.
3. ¿Cuáles son los nombres de las columnas?
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