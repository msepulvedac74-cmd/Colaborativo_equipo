scala> import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.tree.RandomForest

scala> import org.apache.spark.mllib.tree.model.RandomForestModel
import org.apache.spark.mllib.tree.model.RandomForestModel

scala> import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.mllib.util.MLUtils

// Load and parse the data file.

scala> val data = MLUtils.loadLibSVMFile(sc, "c:/spark/data/mllib/sample_libsvm_data.txt")
val data: org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint] = MapPartitionsRDD[35] at map at MLUtils.scala:88

// Split the data into training and test sets (30% held out for testing)

scala> val splits = data.randomSplit(Array(0.7, 0.3))
val splits: Array[org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint]] = Array(MapPartitionsRDD[36] at randomSplit at <console>:1, MapPartitionsRDD[37] at randomSplit at <console>:1)

scala> val (trainingData, testData) = (splits(0), splits(1))
val trainingData: org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint] = MapPartitionsRDD[36] at randomSplit at <console>:1
val testData: org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint] = MapPartitionsRDD[37] at randomSplit at <console>:1

// Train a RandomForest model.
// Empty categoricalFeaturesInfo indicates all features are continuous.

scala> val numClasses = 2
val numClasses: Int = 2

scala> val categoricalFeaturesInfo = Map[Int, Int]()
val categoricalFeaturesInfo: scala.collection.immutable.Map[Int,Int] = Map()

scala> val numTrees = 3
val numTrees: Int = 3

// Use more in practice.

scala> val featureSubsetStrategy = "auto"
val featureSubsetStrategy: String = auto

// Let the algorithm choose.

scala> val impurity = "gini"
val impurity: String = gini

scala> val maxDepth = 4
val maxDepth: Int = 4

scala> val maxBins = 32
val maxBins: Int = 32

scala> val model = RandomForest.trainClassifier( trainingData, numClasses, categoricalFeaturesInfo, numTrees, featureSub
setStrategy, impurity, maxDepth, maxBins )
val model: org.apache.spark.mllib.tree.model.RandomForestModel =
TreeEnsembleModel classifier with 3 trees

scala>

// Evaluate model on test instances and compute test error

scala> val labelAndPreds = testData.map { point =>
     |   val prediction = model.predict(point.features)
     |   (point.label, prediction)
     | }
val labelAndPreds: org.apache.spark.rdd.RDD[(Double, Double)] = MapPartitionsRDD[53] at map at <console>:1

scala> val testErr = labelAndPreds
val testErr: org.apache.spark.rdd.RDD[(Double, Double)] = MapPartitionsRDD[53] at map at <console>:1

scala>   .filter { case (label, pred) => label != pred }
val res6: org.apache.spark.rdd.RDD[(Double, Double)] = MapPartitionsRDD[54] at filter at <console>:1

scala>   .count()
val res7: Long = 0

scala>   .toDouble / testData.count()
val res8: Double = 0.0

scala> println(s"Test Error = $testErr")
Test Error = MapPartitionsRDD[53] at map at <console>:1

scala> println(s"Learned classification forest model:\n ${model.toDebugString}")
Learned classification forest model:
 TreeEnsembleModel classifier with 3 trees

  Tree 0:
    If (feature 433 <= 52.5)
     If (feature 597 <= 253.5)
      Predict: 0.0
     Else (feature 597 > 253.5)
      Predict: 1.0
    Else (feature 433 > 52.5)
     Predict: 1.0
  Tree 1:
    If (feature 511 <= 1.5)
     If (feature 411 <= 36.0)
      Predict: 1.0
     Else (feature 411 > 36.0)
      Predict: 0.0
    Else (feature 511 > 1.5)
     Predict: 0.0
  Tree 2:
    If (feature 434 <= 70.5)
     If (feature 436 <= 1.5)
      Predict: 0.0
     Else (feature 436 > 1.5)
      Predict: 1.0
    Else (feature 434 > 70.5)
     Predict: 1.0
