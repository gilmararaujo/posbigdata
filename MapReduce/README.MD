
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
    <td>50</td>
  </tr>
  <tr>
    <td>Output</td>
    <td>Convert into another set of data

(Key,Value)</td> 
    <td>94</td>
  </tr>
</table>
</p>

<p align="justify">
Reduce Function – Takes the output from Map as an input and combines those data tuples into a smaller set of tuples.
<table style="width:100%">
  <tr>
    <td>Input</td>
    <td>Set of data</td> 
    <td> Bus, Car, bus,  car, train, car, bus, car, train, bus, TRAIN,BUS, buS, caR, CAR, car, BUS, TRAIN</td>
  </tr>
  <tr>
    <td>Output</td>
    <td>Convert into another set of data
(Key,Value)</td> 
    <td>(Bus,1), (Car,1), (bus,1), (car,1), (train,1),

(car,1), (bus,1), (car,1), (train,1), (bus,1),

(TRAIN,1),(BUS,1), (buS,1), (caR,1), (CAR,1),

(car,1), (BUS,1), (TRAIN,1)</td>
  </tr>
</table>
</p>
