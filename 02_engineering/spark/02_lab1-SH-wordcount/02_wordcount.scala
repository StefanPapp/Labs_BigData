#running local on spark-shell
#start spark shell via  spark-shell local

val textFile = sc.textFile("hamlet.txt")
val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
counts.collect()

#hadoop
#copy to hdfs first
val textFile = sc.textFile("hamlet.txt")
val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
counts.collect()

#sidenode, can also use 
val textFile = sc.textFile("file:///root/spark-sandbox/hamlet.txt") 