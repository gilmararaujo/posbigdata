## Understand the development of solutions based on MapReduce with Spark and Scala language
___
<p align="justify">
   Apache Spark is a fast and general engine for large-scale data processing. It can run programs up to 100x faster than Hadoop MapReduce in memory or 10x faster on disk. Apache Spark was created at AMPLabs in UC Berkeley as part of Berkeley Data Analytics Stack (BDAS). Apache Spark has an advanced DAG execution engine that supports acyclic data flow and in-memory computing. Also this, you can write applications and use it interactively quickly in Scala, Python, R shells.
   Spark powers a stack of libraries including SQL and DataFrames, MLlib for machine learning, GraphX, and Spark Streaming. You can combine these libraries seamlessly in the same application.
</p>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/Spark_Stack.jpg">
  <b>Figura 1: Apache Spark Architectural Overview (spark.apache.org).</b>
</p>
<br>
 <p align="justify">     
You can run Spark using its standalone cluster mode, on EC2, on Hadoop YARN, or on Apache Mesos. Access data in HDFS, Cassandra, HBase, Hive, Tachyon, and any Hadoop data source.
</p>
</p>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/data_type_access.jpg">
  <b>Figura 2: Data type access Overview (spark.apache.org).</b>
</p>
<br>

<p align="justify">
Apache Spark provides some advantages like lightning speed of computation, highly accessible, compatibility, convenient and Enhanced productivity.
</p>
<br>

<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/capability.jpg">
  <b>Figura 3: Spark Capability.</b>
</p>

___
<br><br>
### How Apache Spark works
 <p align="justify"> 
Apache Spark engine execute your  data processing in a distributed memory over a cluster of machines. In the figure below we can see a logical diagram of how a typical Spark job processes:
</p>

</br>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/spark_job_process.JPG">
  <b>Figura 4: Spark job process.</b>
</p>
</br>

### How does Apache Spark execute a job
<p align="justify"> 
The user’s driver program launches multiple workers, which read data blocks from a distributed file system and can persist computed RDD partitions in memory.
</p>

<br>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/Spark_runtime.jpg">
  <b>Figura 5: Spark runtime.</b>
</p>
</br>

### Apache Spark - Resilient Distributed Dataset (RDD)
<p align="justify"> 
An RDD is the basic unit of data in Spark upon which all Operations are performed. RDDs are intermediate results stored in Memory and are Partitioned to be operated on multiple nodes in the Cluster.
An RDD Operation can be either be actions or transformations. Action returns result to the Driver Program or write it to the Storage. An action normally starts a Computation to provide result and always return some other data type other than RDD. Transformation returns Pointer to new RDD.

</p>
<br>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/RDDsparkProcess.JPG">
  <b>Figura 6: RDD Apache Spark job process.</b>
</p>
</br>

<p align="justify"> 
Lazy Evaluation helps to optimize the Disk and Memory Usage in Spark. The benefit of Lazy Evaluation is that we only need to read the first line from the File instead of the whole file and also there is no need to store the complete file content in Memory.
When we create new RDDs based on the existing RDDs, Spark manage these dependencies using Lineage Graph.
</p>
<p align="justify"> 
Let’s understand this conceptually by using with a example. We want to find the 100 most commonly used words in a text file. We can see a possible solution in Figure 7:
</p>

<br>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/wordCounSample.jpg">
  <b>Figura 7: Word Count job process.</b>
</p>
</br>

---

### Some examples in terms of use Apache Spark with Scala language

<p align="justify"> 
First of all, you should download of Cloudera VM. After that, you have  to put your files into the Hadoop Distributed File System (HDFS). 

For example:</br>
#hadoop fs -put /home/cloudera/input /user/cloudera/output

Then, start the Spark Shell: </br>
#spark-shell
</br>
and, execute the algorithm bellow.
</br> </br>
1 - Count all occurrences of words (removing prepositions and things like that). </br> </br>
val text = sc.textFile("hdfs://localhost:8020/user/cloudera/input/text.txt").cache()
val stopWords = sc.textFile("file:///home/cloudera/stopwords.txt").cache() //stanfordnlp -> CoreNLP
val stopWordSet = stopWords.collect.toSet
val stopWordSetBC = sc.broadcast(stopWordSet) //send to any worker
val words = text.flatMap(str => str.split("\\W")).filter(!_.isEmpty)
val clean = words.mapPartitions{iter =>
    val stopWordSet = stopWordSetBC.value
    iter.filter(word => !stopWordSet.contains(word))
}
val wordCount = clean.flatMap(str => str.split(" ")).filter(!_.isEmpty).map(word => (word,1)).reduceByKey( _ + _ )
wordCount.foreach(word => println(word))
wordCount.saveAsTextFile("hdfs://localhost:8020/user/cloudera/output/")

<br>

2 - Count words by book. </br> </br>
val rdd = sc.textFile("hdfs://localhost:8020/user/cloudera/input")
val counts = rdd.flatMap(str => str.split(" ")).filter(!_.isEmpty).map(word => (word, 1)).reduceByKey( _ + _ )
counts.saveAsTextFile("hdfs://localhost:8020/user/cloudera/output")
topWordCount.take(100).foreach(x => println(x))

<br>

3 - Provide a word and show in which files we find the word. </br> </br>
val rdd = sc.wholeTextFiles("file:///home/cloudera/a.txt").cache()
 val files = rdd.map { case (filename, content) => filename}
def doProcess(file: String) = { 
	 val word = "z"//input word
	 val rdd2 = sc.textFile(file);
	 val wordFound = rdd2.flatMap(str => str.split(" ")).filter(text => text.contains(word)).collect().mkString(" ");
	 println("Word: %s => filename %s".format(wordFound,file));
}
files.collect.foreach( filename => {
    doProcess(filename)
}) 

<br>

4- Provide a palvra and show in which files we find the word and amount of occurrences. </br> </br>
val rdd = sc.wholeTextFiles("hdfs://localhost:8020/user/cloudera/input")
val files = rdd.map { case (filename, content) => filename}
def doProcess(file: String) = { 
	 val word = "z"//input word
	 val rdd2 = sc.textFile(file);
	 val wordFoundCount = text.flatMap(str => str.split(" ")).filter(text => text.contains(word)).map(word => (word, 1)).reduceByKey(_+_).collect().mkString(" ");
	 println("Word, total: %s => filename %s".format(wordFoundCount,file));
}
files.collect.foreach( filename => {
    doProcess(filename)
}) 

<br>

5 - Find the 1500 most used words in all books. </br> </br>
val rdd = sc.textFile("hdfs://localhost:8020/user/cloudera/input/*")
val topWordCount = rdd.flatMap(str => str.split(" ")).filter(!_.isEmpty).map(word => (word,1)).reduceByKey( _ + _).map{case (word, count) => (count, word)}.sortByKey(false)
topWordCount.saveAsTextFile("hdfs://localhost:8020/user/cloudera/output")
topWordCount.take(1500).foreach(x => println(x))

<br>

6 - Find the 1500 most used words in 1 book. </br> </br>
val rdd = sc.textFile("hdfs://localhost:8020/user/cloudera/input")
val topWordCount = rdd.flatMap(str => str.split(" ")).filter(!_.isEmpty).map(word => (word,1)).reduceByKey( _ + _ ).map{case (word, count) => (count, word)}.sortByKey(false)
topWordCount.saveAsTextFile("hdfs://localhost:8020/user/cloudera/output")
topWordCount.take(10).foreach(x => println(x))

<br>

7- Find the 1500 least used words. </br> </br>
val rdd = sc.textFile("hdfs://localhost:8020/user/cloudera/input/*")
val rddone = sc.textFile("hdfs://localhost:8020/user/cloudera/input/")
val topWordCount = rdd.flatMap(str => str.split(" ")).filter(!_.isEmpty).map(word => (word,1)).reduceByKey( _ + _ ).map{case (word, count) => (count, word)}.sortByKey()
topWordCount.saveAsTextFile("hdfs://localhost:8020/user/cloudera/output")
topWordCount.take(1500).foreach(x => println(x))

<br>

8 - Find the common vocabulary of 1500 words between 2 books. </br> </br>
val file1 = sc.textFile("hdfs://localhost:8020/user/cloudera/input")
val file2 = sc.textFile("hdfs://localhost:8020/user/cloudera/input")
val book1 = file1.flatMap(str => str.split(" ")).map(word => (word, 1)).reduceByKey( _ + _)
val book2 = file2.flatMap(str => str.split(" ")).map(word => (word, 1)).reduceByKey( _ + _)
val result = book1.intersection(book2)
result.saveAsTextFile("hdfs://localhost:8020/user/cloudera/output")
result.take(1500).foreach(x => println(x))

<br>

9- Find the different word vocabulary of each book between 2 books, and remove the words that are found in both books. </br> </br>
val file1 = sc.textFile("hdfs://localhost:8020/user/cloudera/input")
val file2 = sc.textFile("hdfs://localhost:8020/user/cloudera/input")
val book1 = file1.flatMap(str => str.split(" ")).map(word => (word, 1)).reduceByKey( _ + _ )
val book2 = file2.flatMap(str => str.split(" ")).map(word => (word, 1)).reduceByKey( _ + _ )
val result = book1.subtractByKey(book2)
val temp = data.union(data1)
val rem = temp.subtractByKey(res)
rem.saveAsTextFile("hdfs://localhost:8020/user/cloudera/output")
rem.take(10).foreach(x => println(x))


</p>
