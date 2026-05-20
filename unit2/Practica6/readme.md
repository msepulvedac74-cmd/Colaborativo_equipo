scala> import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}

scala> import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.mllib.util.MLUtils

scala> // Load and parse the data file. 

scala> val data = MLUtils.loadLibSVMFile(sc, "./sample_data.txt")
val data: org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint] = MapPartitionsRDD[6] at map at MLUtils.scala:88

scala> // Split data into training (60%) and test (40%).

scala> val Array(training, test) = data.randomSplit(Array(0.6, 0.4))
val training: org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint] = MapPartitionsRDD[7] at randomSplit at <console>:1
val test: org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint] = MapPartitionsRDD[8] at randomSplit at <console>:1

scala> val model = NaiveBayes.train(training, lambda = 1.0, modelType = "multinomial")
val model: org.apache.spark.mllib.classification.NaiveBayesModel = org.apache.spark.mllib.classification.NaiveBayesModel@40188fe6

scala> val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))
val predictionAndLabel: org.apache.spark.rdd.RDD[(Double, Double)] = MapPartitionsRDD[24] at map at <console>:1

scala> val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()
val accuracy: Double = 0.9772727272727273