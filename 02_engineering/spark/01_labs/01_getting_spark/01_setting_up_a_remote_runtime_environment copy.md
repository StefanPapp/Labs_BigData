#Scope
These series targets to help students to learn Apache Spark. This tutorial was built for Spark 2.0. 

The focus of this part is to
* Get Apache Spark running in a local environment

#Prerequirements
This tutorial work with Linux, Windows and Mac OS X. As we executing remote, we need internet access.

You will need: 
* A Web Browser 
* windows users: ssh client (such as putty)

#Local Installation
There are three main ways to get to Apache Spark: 
1. Get Apache Spark from GIT and compile it
2. Download Apache Spark Binaries, extract them and execute test examples
3. Get a Hadoop Sandbox (either VM or Docker) and execute test examples

#local (without Hadoop)
1. download spark binaries and run without Hadoop
2. Download spark source and compile

#local Hadoop
1. Download a Hortonworks Sandbox image

# Hadoop
* Have Hadoop Cluster

# Cloud
* Create a HAdoop image in the Cloud
* Databricks cloud


#Directories
The Lab assumes /src/lab/ as main directory. Change paths if necessary 

#smoke test
1. Start Shell

if you want to work with Scala 
    > spark-shell
    
    For Python
    > pyspark

2. Take a look at the spark context and some attributes

> sc
> sc.appName
> sc.master



# Further optional Activities
1. Build Apache Spark
2. Install a local Hadoop Sandbox (docker or vm) and run spark