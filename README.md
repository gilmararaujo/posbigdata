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

<br>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/spark_job_process.JPG">
  <b>Figura 4: Spark job process.</b>
</p>

### How does Apache Spark execute a job
 <p align="justify"> 
The user’s driver program launches multiple workers, which read data blocks from a distributed file system and can persist computed RDD partitions in memory.
</p>

<br>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/Spark_runtime.jpg">
  <b>Figura 5: Spark job process.</b>
</p>


### Apache Spark - Resilient Distributed Dataset (RDD)
<p align="justify"> 
Lazy Evaluation helps to optimize the Disk & Memory Usage in Spark.
</p>
<br>
<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/images/RDDsparkProcess.JPG">
  <b>Figura 6: Spark job process.</b>
</p>
