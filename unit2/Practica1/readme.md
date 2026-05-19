// Import LinearRegression
scala> import org.apache.spark.sql.SparkSession
scala> import org.apache.spark.ml.regression.LinearRegression


// Opcional: Utilice el siguiente codigo para configurar errores
scala> import org.apache.log4j._
scala> Logger.getLogger("org").setLevel(Level.ERROR)



// Inicie una simple Sesion Spark
scala> val spark = SparkSession.builder().getOrCreate()
val spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.classic.SparkSession@7270c811


// Utilice Spark para el archivo csv Clean-Ecommerce .
scala> val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("Clean-USA-Housing.csv")
val data: org.apache.spark.sql.DataFrame = [Avg Area Income: double, Avg Area House Age: double ... 4 more fields]

// Imprima el schema en el DataFrame.
scala> data.printSchema
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
root
 |-- Avg Area Income: double (nullable = true)
 |-- Avg Area House Age: double (nullable = true)
 |-- Avg Area Number of Rooms: double (nullable = true)
 |-- Avg Area Number of Bedrooms: double (nullable = true)
 |-- Area Population: double (nullable = true)
 |-- Price: double (nullable = true)


// Imprima un renglon de ejemplo del DataFrane.
scala> data.head(1)
val res23: Array[org.apache.spark.sql.Row] = Array([79545.45857431678,5.682861321615587,7.009188142792237,4.09,23086.800502686456,1059033.5578701235])


scala> val colnames = data.columns
val colnames: Array[String] = Array(Avg Area Income, Avg Area House Age, Avg Area Number of Rooms, Avg Area Number of Bedrooms, Area Population, Price)

scala> val firstrow = data.head(1)(0)
val firstrow: org.apache.spark.sql.Row = [79545.45857431678,5.682861321615587,7.009188142792237,4.09,23086.800502686456,1059033.5578701235]

scala> println("\n")

scala> println("Example data row")
Example data row

scala> for(ind <- Range(1, colnames.length)){
     |     println(colnames(ind))
     |     println(firstrow(ind))
     |     println("\n")
     | }
Avg Area House Age
5.682861321615587

Avg Area Number of Rooms
7.009188142792237

Avg Area Number of Bedrooms
4.09

Area Population
23086.800502686456

Price
1059033.5578701235

scala> import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.VectorAssembler

// Importe VectorAssembler y Vectors
scala> import org.apache.spark.ml.linalg.Vectors


scala>

scala> data.columns
val res27: Array[String] = Array(Avg Area Income, Avg Area House Age, Avg Area Number of Rooms, Avg Area Number of Bedrooms, Area Population, Price)


// Deje todo esto como un nuevo DataFrame que se llame df

scala> val df = data.select(data("Price").as("label"), $"Avg Area Income", $"Avg Area House Age", $"Avg Area Number of Rooms", $"Avg
Area Number of Bedrooms", $"Area Population")
val df: org.apache.spark.sql.DataFrame = [label: double, Avg Area Income: double ... 4 more fields]

// Transforme el data frame para que tome la forma de ("label","features")
scala> //val df = data.select(data("Price").as"label"), $"Avg Area Income", $"Avg Area House Age", $"Avg Area Number of Rooms", $"Avg Area Number of Bedrooms", $"Area Population")

// Que el objeto assembler convierta los valores de entrada a un vector


scala> val assembler = new VectorAssembler().setInputCols(Array("Avg Area Income", "Avg Area House Age", "Avg Area Number of Rooms",
"Avg Area Number of Bedrooms", "Area Population")).setOutputCol("features")
val assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_967e51d72036, handleInvalid=error, numInputCols=5

scala> val output = assembler.transform(df).select($"label", $"features")
val output: org.apache.spark.sql.DataFrame = [label: double, features: vector]

scala>

scala> output.show()
+------------------+--------------------+
|             label|            features|
+------------------+--------------------+
|1059033.5578701235|[79545.4585743167...|
|  1505890.91484695|[79248.6424548256...|
|1058987.9878760849|[61287.0671786567...|
|1260616.8066294468|[63345.2400462279...|
| 630943.4893385402|[59982.1972257080...|
|1068138.0743935304|[80175.7541594853...|
|1502055.8173744078|[64698.4634278877...|
|1573936.5644777215|[78394.3392775308...|
| 798869.5328331633|[59927.6608133496...|
|1545154.8126419624|[81885.9271840956...|
| 1707045.722158058|[80527.4720829228...|
| 663732.3968963273|[50593.6954970428...|
|1042814.0978200928|[39033.8092369823...|
|1291331.5184858206|[73163.6634410467...|
|1402818.2101658515|[69391.3801843616...|
|1306674.6599511993|[73091.8667458232...|
|1556786.6001947748|[79706.9630576574...|
| 528485.2467305964|[61929.0770180892...|
|1019425.9367578316|[63508.1942994299...|
|1030591.4292116085|[62085.2764034048...|
+------------------+--------------------+
only showing top 20 rows


// Crear un objeto para modelo de regresion linea.

scala> val lr = new LinearRegression()
val lr: org.apache.spark.ml.regression.LinearRegression = linReg_679d8a16a963

// Ajuste el modelo para los datos y llame a este modelo lrModelo
scala> val lrModel = lr.fit(output)
val lrModel: org.apache.spark.ml.regression.LinearRegressionModel = LinearRegressionModel: uid=linReg_679d8a16a963, numFeatures=5

// Resuma el modelo sobre el conjunto de entrenamiento imprima la salida de algunas metricas! 
// Utilize metodo .summary de nuestro  modelo para crear un objeto llamado trainingSummary
scala> val trainingSummary = lrModel.summary
val trainingSummary: org.apache.spark.ml.regression.LinearRegressionTrainingSummary = org.apache.spark.ml.regression.LinearRegressionTrainingSummary@7b15de86

// Muestre los valores de residuals, el RMSE, el MSE, y tambien el R^2 .
scala> trainingSummary.residuals.show()
+-------------------+
|          residuals|
+-------------------+
|-164813.48488342343|
| 10953.223229613388|
| -194028.7582053577|
| 139392.73897870956|
|-214445.27695672144|
| -701.0813313485123|
| -168103.7946608388|
|  3974.217703607166|
| 32978.449035998085|
|   76897.3040503161|
| -66939.03875315515|
|  34017.77569352917|
|  91027.54522960435|
|-14496.722959607607|
|  96010.27173951524|
|  67115.24134960677|
| 34045.648309225915|
|  40333.55834060407|
|-117424.29344359622|
| -170059.0470152503|
+-------------------+
only showing top 20 rows

scala> trainingSummary.predictions.show()
+------------------+--------------------+------------------+
|             label|            features|        prediction|
+------------------+--------------------+------------------+
|1059033.5578701235|[79545.4585743167...| 1223847.042753547|
|  1505890.91484695|[79248.6424548256...|1494937.6916173366|
|1058987.9878760849|[61287.0671786567...|1253016.7460814426|
|1260616.8066294468|[63345.2400462279...|1121224.0676507372|
| 630943.4893385402|[59982.1972257080...| 845388.7662952617|
|1068138.0743935304|[80175.7541594853...| 1068839.155724879|
|1502055.8173744078|[64698.4634278877...|1670159.6120352466|
|1573936.5644777215|[78394.3392775308...|1569962.3467741143|
| 798869.5328331633|[59927.6608133496...| 765891.0837971652|
|1545154.8126419624|[81885.9271840956...|1468257.5085916463|
| 1707045.722158058|[80527.4720829228...|1773984.7609112132|
| 663732.3968963273|[50593.6954970428...| 629714.6212027981|
|1042814.0978200928|[39033.8092369823...| 951786.5525904885|
|1291331.5184858206|[73163.6634410467...|1305828.2414454282|
|1402818.2101658515|[69391.3801843616...|1306807.9384263363|
|1306674.6599511993|[73091.8667458232...|1239559.4186015925|
|1556786.6001947748|[79706.9630576574...| 1522740.951885549|
| 528485.2467305964|[61929.0770180892...|488151.68838999234|
|1019425.9367578316|[63508.1942994299...|1136850.2302014278|
|1030591.4292116085|[62085.2764034048...|1200650.4762268588|
+------------------+--------------------+------------------+
only showing top 20 rows

scala> trainingSummary.r2 //variaza que hay
val res31: Double = 0.9180238195089547

scala> trainingSummary.rootMeanSquaredError
val res32: Double = 101092.70158252298