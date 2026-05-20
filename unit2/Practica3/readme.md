scala> import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier

scala> import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

scala> // Load the data stored in LIBSVM format as a DataFrame.

scala> val data = spark.read.format("libsvm").load("C:/Spark/data/mllib/sample_multiclass_classification_data.txt")
val data: org.apache.spark.sql.DataFrame = [label: double, features: vector]

scala> val Array(training, test) = data.randomSplit(Array(0.6, 0.4), seed = 12345)
val training: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]
val test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]

scala> // specify layers for the neural network:
scala> // input layer of size 4 (features), two intermediate of size 5 and 4
scala> // and output of size 3 (classes).

scala> val layers = Array[Int](4, 5, 4, 3)
val layers: Array[Int] = Array(4, 5, 4, 3)

scala> // create the trainer and set its parameters

scala> val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(
100)
val trainer: org.apache.spark.ml.classification.MultilayerPerceptronClassifier = mlpc_f9d2f397cd67

scala> // train the model

scala> val model = trainer.fit(training)
val model: org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel = MultilayerPerceptronClassificationModel: uid=mlpc_f9d2f397cd67, numLayers=4, numClasses=3, numFeatures=4

scala> // compute accuracy on the test set

scala> val result = model.transform(test)
val result: org.apache.spark.sql.DataFrame = [label: double, features: vector ... 3 more fields]

scala> val predictionAndLabels = result.select("prediction", "label")
val predictionAndLabels: org.apache.spark.sql.DataFrame = [prediction: double, label: double]

scala> val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
val evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = MulticlassClassificationEvaluator: uid=mcEval_76060ba3135f, metricName=accuracy, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala> println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
Test set accuracy = 0.9607843137254902