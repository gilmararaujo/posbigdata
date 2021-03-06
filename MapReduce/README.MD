
## An introduction to the basics of MapReduce using Hadoop and Java
___

<p align="justify">
Hadoop MapReduce is a software framework for easily writing applications which process vast amounts of data (multi-terabyte data-sets) in-parallel on large clusters (thousands of nodes) of commodity hardware in a reliable, fault-tolerant manner.
</p>
<p align="justify">
A MapReduce job usually splits the input data-set into independent chunks which are processed by the map tasks in a completely parallel manner. The framework sorts the outputs of the maps, which are then input to the reduce tasks. Typically both the input and the output of the job are stored in a file-system. The framework takes care of scheduling tasks, monitoring them and re-executes the failed tasks.
</p>
<p align="justify">
MapReduce consists of 2 steps:

Map Function – It takes a set of data and converts it into another set of data, where individual elements are broken down into tuples (Key-Value pair).


<table style="width:100%">
  <tr>
    <td>Input</td>
    <td>Set of data</td> 
    <td>Deer, Bear, River, Car, Car, River, Deer, Car, Bear</td>
  </tr>
  <tr>
    <td>Output</td>
    <td>Convert into another set of data
        (Key,Value)</td> 
    <td>(Deer,1), (Bear,1), (River,1), (car,1), (Car,1), (River,1), (Deer,1), (Car,1), (Bear,1)</td>
  </tr>
</table>
</p>

<p align="justify">
Reduce Function – Takes the output from Map as an input and combines those data tuples into a smaller set of tuples.
<table style="width:100%">
  <tr>
    <td>Input</td>
    <td>Set of Tuples</td> 
    <td>(Deer,1), (Bear,1), (River,1), (car,1), (Car,1), (River,1), (Deer,1), (Car,1), (Bear,1)</td>
  </tr>
  <tr>
    <td>Output</td>
    <td>Convert into another set of data
(Key,Value)</td> 
    <td>(Bear,2), (Car,3),(Deer,2),(River,2)</td>
  </tr>
</table>
</p>

## Work Flow

<p align="center">
  <img src="https://github.com/gilmararaujo/posbigdata/blob/master/MapReduce/images/MapReduceWordCount.png">
  <b>Figura 1: WordCount MapReduce workflow (Joel Adams).</b>
</p>

</br>

## Workflow of MapReduce consists of 5 steps

<p align="center">

Splitting – splitting by space, comma, semicolon, or even by a new line ('\n' );

Mapping – Mapper maps input key/value pairs to a set of intermediate key/value pairs;

Intermediate splitting – the entire process in parallel on different clusters. In order to group them in "Reduce Phase the similar KEY data should be on same cluster.

Reduce – Reducer reduces a set of intermediate values which share a key to a smaller set of values;

Combining – Input to the Reducer is the sorted output of the mappers. In this phase where all the data (individual result set from each cluster) is combine together to form a result.
</p>

## We can see an example of mapreduce through the execution of the jars:


WordCountPath.jar and wordcountcap.jar </br>
<p align="justify">
First of all, you should download of Cloudera VM. After that, you have to put your files (txt) into the Hadoop Distributed File System (HDFS).
</p>

For example: </br>
#hdfs dfs -copyFromLocal /home/cloudera/input </br>
#hdfs dfs -ls /user/cloudera/input</br></br>
Then, execute the algorithm: </br>
#hadoop jar WordCountPath.jar /user/cloudera/input /user/cloudera/output </br>
#hadoop jar wordcountcap.jar /user/cloudera/input /user/cloudera/output
</p>
