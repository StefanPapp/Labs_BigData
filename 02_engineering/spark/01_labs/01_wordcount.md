#Preconditions
* Spark binary is in the path environment
* Wget is available
* spark

#steps
1. Download a text file: 
In this exercise, we use file "hamlet.txt". Feel free to replace Hamlet with one of your own choices.

wget -O hamlet.txt http://www.gutenberg.org/cache/epub/1787/pg1787.txt /workspace/data/hamlet.txt

1.  Create an RDD from the file we just viewed above

val baseRdd = sc.textFile("file:///workspace/data/hamlet.txt")

2.  Verify that you can read the content of the RDD

baseRdd.first()
    
    Understanding question:
        * Is the take operation a transformation or an action?
        * once you decided for action/transformation, name one or two other methods of the same type that make sense
        * When you try to get back values, the output displays something such as: "res7: String = This etext is a typo-corrected version of Shakespeare's Hamlet," - Try now to print(res7) 
        * Can you also assign the return value to a variable of your liking
        
3.  Each element is currently a string, transform the string into arrays and examine the output

val splitRdd = baseRdd.flatMap(line => line.split(" "))
splitRdd.take(5) 
     
    Understanding question:
        * Can you interpret wat the result?
        * Can you now say why flatMap is a transformation and how a transformation is different to an action?
        * What does val do? How does it differ from var?

4.  Now based on the result, we map each element into a key value pair, with the key being the word and the value being

val mappedRdd = splitRdd.map(line=> (line,1)) 
mappedRdd.take(5)

    Understanding question:
        Describe the difference between a map and a flatmap transformation.

5.  Reduce the key value pairs to get the count of each word

val reducedRdd = mappedRdd.reduceByKey((a,b) => a+b)

6.  Run an action to get output.

reducedRdd.take(20)
reducedRdd.collect()
 
7.  Challenge:  
* Find the ten most prominent words
* Looking at the results, what still can be improved  
 
 val sortedWordCount = countByKey.sortBy(kvp => kvp._2, false)
   
RESULT: You should now know how to start the spark shell and perform some basic RDD transformations and actions. 

val data = spark.read.text("/workspace/data/hamlet.txt").as[String]
val words = data.flatMap(value => value.split("\\s+"))
val groupedWords = words.groupByKey(_.toLowerCase)
val counts = groupedWords.count()
counts.show()

