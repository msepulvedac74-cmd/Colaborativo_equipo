/?Crear spark session
scala> import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession

scala>

scala> val spark = SparkSession.builder()
val spark: org.apache.spark.sql.SparkSession.Builder = org.apache.spark.sql.SparkSession$Builder@66c16751

scala>   .appName("DecisionTreeCreditExample")
val res1: spark.type = org.apache.spark.sql.SparkSession$Builder@66c16751

scala>   .getOrCreate()
val res2: org.apache.spark.sql.SparkSession = org.apache.spark.sql.classic.SparkSession@63a7a23a

scala>

//Crear dataset
val res3: Int = 2

scala> val data = Seq(
     |   (1.0,0.0,1.0,1.0),
     |   (1.0,0.0,1.0,1.0),
     |   (1.0,1.0,1.0,1.0),
     |   (1.0,0.0,0.0,0.0),
     |   (1.0,1.0,0.0,0.0),
     |   (0.0,1.0,0.0,0.0),
     |   (0.0,1.0,0.0,0.0),
     |   (0.0,0.0,1.0,1.0),
     |   (0.0,1.0,1.0,0.0),
     |   (0.0,0.0,0.0,0.0)
     | ).toDF("income_high","has_debt","good_history","label")
val data: org.apache.spark.sql.DataFrame = [income_high: double, has_debt: double ... 2 more fields]


scala> data.show()
+-----------+--------+------------+-----+
|income_high|has_debt|good_history|label|
+-----------+--------+------------+-----+
|        1.0|     0.0|         1.0|  1.0|
|        1.0|     0.0|         1.0|  1.0|
|        1.0|     1.0|         1.0|  1.0|
|        1.0|     0.0|         0.0|  0.0|
|        1.0|     1.0|         0.0|  0.0|
|        0.0|     1.0|         0.0|  0.0|
|        0.0|     1.0|         0.0|  0.0|
|        0.0|     0.0|         1.0|  1.0|
|        0.0|     1.0|         1.0|  0.0|
|        0.0|     0.0|         0.0|  0.0|
+-----------+--------+------------+-----+


//Crear columnas
val res5: Int = 3

scala>

scala> import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.VectorAssembler

scala> val assembler = new VectorAssembler()
val assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_296ccefcc4c8, handleInvalid=error

scala>   .setInputCols(Array("income_high","has_debt","good_history"))
val res6: assembler.type = VectorAssembler: uid=vecAssembler_296ccefcc4c8, handleInvalid=error, numInputCols=3

scala>   .setOutputCol("features")
val res7: res6.type = VectorAssembler: uid=vecAssembler_296ccefcc4c8, handleInvalid=error, numInputCols=3


scala> val dataset = assembler.transform(data)
val dataset: org.apache.spark.sql.DataFrame = [income_high: double, has_debt: double ... 3 more fields]

scala> dataset.select("features","label").show()
+-------------+-----+
|     features|label|
+-------------+-----+
|[1.0,0.0,1.0]|  1.0|
|[1.0,0.0,1.0]|  1.0|
|[1.0,1.0,1.0]|  1.0|
|[1.0,0.0,0.0]|  0.0|
|[1.0,1.0,0.0]|  0.0|
|[0.0,1.0,0.0]|  0.0|
|[0.0,1.0,0.0]|  0.0|
|[0.0,0.0,1.0]|  1.0|
|[0.0,1.0,1.0]|  0.0|
|    (3,[],[])|  0.0|
+-------------+-----+


//Train/test

scala> val Array(trainingData, testData) = dataset.randomSplit(Array(0.7, 0.3), seed = 42)
val trainingData: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [income_high: double, has_debt: double ... 3 more fields]
val testData: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [income_high: double, has_debt: double ... 3 more fields]

//Crear decision Treee Classifier

scala> import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.classification.DecisionTreeClassifier

scala> val dt = new DecisionTreeClassifier()
val dt: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_756b034d865c

scala>   .setLabelCol("label")
val res11: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_756b034d865c

scala>   .setFeaturesCol("features")
val res12: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_756b034d865c

scala>   .setMaxDepth(3)
val res13: res12.type = dtc_756b034d865c

//Entrenamiento del modelo

scala> val model = dt.fit(trainingData)
val model: org.apache.spark.ml.classification.DecisionTreeClassificationModel = DecisionTreeClassificationModel: uid=dtc_756b034d865c, depth=2, numNodes=5, numClasses=2, numFeatures=3

//mostrar el arbol aprendido

scala> println(model.toDebugString)
DecisionTreeClassificationModel: uid=dtc_756b034d865c, depth=2, numNodes=5, numClasses=2, numFeatures=3
  If (feature 1 <= 0.5)
   If (feature 2 <= 0.5)
    Predict: 0.0
   Else (feature 2 > 0.5)
    Predict: 1.0
  Else (feature 1 > 0.5)
   Predict: 0.0


//predicciones

scala> val predictions = model.transform(testData)
val predictions: org.apache.spark.sql.DataFrame = [income_high: double, has_debt: double ... 6 more fields]

scala>

scala> predictions.select("features","label","prediction","probability").show(false)
+-------------+-----+----------+-----------+
|features     |label|prediction|probability|
+-------------+-----+----------+-----------+
|[1.0,0.0,1.0]|1.0  |1.0       |[0.0,1.0]  |
|[1.0,1.0,1.0]|1.0  |0.0       |[1.0,0.0]  |
|[1.0,0.0,0.0]|0.0  |0.0       |[1.0,0.0]  |
+-------------+-----+----------+-----------+


//Evaluacion

scala> import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

scala> val evaluator = new MulticlassClassificationEvaluator()
val evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = MulticlassClassificationEvaluator: uid=mcEval_b1d44764806b, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala>   .setLabelCol("label")
val res20: evaluator.type = MulticlassClassificationEvaluator: uid=mcEval_b1d44764806b, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala>   .setPredictionCol("prediction")
val res21: res20.type = MulticlassClassificationEvaluator: uid=mcEval_b1d44764806b, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala>   .setMetricName("accuracy")
val res22: res21.type = MulticlassClassificationEvaluator: uid=mcEval_b1d44764806b, metricName=accuracy, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala> val accuracy = evaluator.evaluate(predictions)
val accuracy: Double = 0.6666666666666666



scala> println("Accuracy = " + accuracy)
Accuracy = 0.6666666666666666
