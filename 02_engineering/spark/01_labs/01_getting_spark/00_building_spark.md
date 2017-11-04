## Goal of this Lab
* Building Apache Spark

## To be able to execute Apache Spark, you need
* Java installation (Java 1.8.x or higher recommended)

## For building Apache Spark, you need in addition:
* Git (to receive spark sources)
* Apache Maven (to build the sources)

#Local Installation
There are three main ways to get to Apache Spark: 
1. Get Apache Spark from GIT and compile it
2. Download Apache Spark Binaries, extract them and execute test examples
3. Get a Hadoop Sandbox (either VM or Docker) and execute test examples

## Building Apache Spark
You can download alternatively the sources from the Databricks website. 

### Steps
1. Go to your work directory
2. Get Sources via GIT
3. Build
4. NEXT STEP: Smoke test

### details
cd /workspace/src/apache/spark
mkdir build ; cd build
git clone https://github.com/apache/spark.git 
cd spark
export MAVEN_OPTS="-Xmx2g -XX:ReservedCodeCacheSize=512m"
mvn -DskipTests clean package
./build/mvn -Pyarn -Phadoop-2.7 -Dhadoop.version=2.7.0 -DskipTests clean package

### Refences
http://spark.apache.org/docs/latest/building-spark.html

#smoke test
./bin/run-example SparkPi 10
./bin/spark-shell --master local

##in the shell
> sc
> sc.appName
> sc.master

#adding to path

# Further optional Activities
1. Install a local Hadoop Sandbox (docker or vm) and run spark
2. Go to the cloud

# Reference
http://spark.apache.org/docs/latest/