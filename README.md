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
