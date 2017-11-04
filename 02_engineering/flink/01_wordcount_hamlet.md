1. Start Flink /bin/start_local.sh
2. start  shell 

case class Word (word: String, frequency: Int)

val lines: DataSet[String] = benv.readTextFile("/workspace/hamlet.txt")
lines.flatMap {line => line.split(" ").map(word => Word(word,1))}.groupBy("word").sum("frequency").print()
