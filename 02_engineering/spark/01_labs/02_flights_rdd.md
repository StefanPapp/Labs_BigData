#Lab Steps

1. Loading data
> val flightRdd=sc.textFile("file:///src/lab/lab2/flights.csv").map(line => line.split(","))

2.	The first goal of this lab is to find top 3 airlines with the most flights.
a.	Create an RDD for flight.csv and split it into arrays
>>> val flightRdd=sc.textFile("/user/root/flight.csv").
 	map(line => line.split(","))

val carrierRdd = flightRdd.map(line => (line(8),1))
carrierRdd.take(1)

val reducedRdd = carrierRdd.reduceByKey((a,b) => a+b)


d.	Using sortByKey, find the top 3 airlines.

4.	Find the top 5 most common routes, between two cities.
a.	This application also looks like a word count, but the key is made up of more then one field.  Also, there might be more than one airport for each city, make sure to take that into account.

b.	Reuse the flightRdd created in 3a, and create an airportsRdd using airports.csv
>>> val airportsRdd = sc.textFile("/user/root/airports.csv").
 		map(line=> line.split(","))

c.	Create a new rdd using the smallest amount of required data, and join the airportsRdd to flightsRdd.
i.	Prep the airports and flightRdd to only keep whats needed
>>> val cityRdd = airportsRdd.
 		map(line=> (line(0), line(2)))
>>> val flightOrigDestRdd = flightRdd.
 		map(line=> (line(12), line(13)))
ii.	Join the rdds to get the correct city, retaining only the required data


d.	Map the citiesRdd to a new rdd that is ready to then do a reduceByKey

5.	Challenge: Find the longest departure delay for each airline if its over 15 minutes
a.	This application is similar to a word count, believe it or not.
b.	Filter out all departure delays less then 15 minutes
c.	Instead of adding together values, compare them to find the longest for each key
*Hint math.max(a,b) returns the greater of the two values, make sure you’re comparing ints, the data is read as a string until casted

6.	Challenge: Find the most common airplane model for flights over 1500 miles
*Note Not all data is perfect (plane-data.csv has some missing values), make sure to filter out airplane model records that don’t contain 9 fields after it is split into an array






















Solutions:

3a
>>> val flightRdd=sc.textFile("/user/root/flight.csv").
map(line => line.split(","))

3b
>>> val carrierRdd = flightRdd.map(line => (line(5),1))
>>> carrierRdd.take(1)

3c
>>> val carrierReduce = carrierRdd.reduceByKey((a,b) => a+b)

3d
>>> val carriersSorted = carrierReduce.map{case (a,b) => (b,a)}.
sortByKey(false)
>>> carriersSorted.take(3)

4b
>>> val airportsRdd = sc.textFile("/user/root/airports.csv").
map(line=> line.split(","))

4ci
>>> val cityRdd = airportsRdd.map(line=> (line(0), line(2)))
>>> val flightOrigDestRdd = flightRdd.
map(line=> (line(12), line(13)))

4cii
>>> val origJoinRdd = flightOrigDestRdd.join(cityRdd)
>>> val destAndOrigJoinRdd = origJoinRdd.
map{case(a,(b,c))=> (b,c)}.join(cityRdd)
>>> val citiesCleanRdd = destAndOrigJoinRdd.values

4d
>>> val citiesReducedRdd = citiesCleanRdd.
map(line=> (line,1)).reduceByKey((a,b)=> a+b)
4e
>>> citiesReducedRdd.map{case (a,b)=> (b,a)}.
sortByKey(false).take(5)

5
>>>flightRdd.filter(line=> line(11).toInt > 15).
map(line=> (line(5), line(11).toInt)).
reduceByKey((a,b)=> math.max(a,b)).take(10)

6
>>> val airplanesRdd = sc.textFile("/user/root/plane-data.csv").
map(line=> line.split(",")).filter(line=> line.length == 9)
>>> val flight15Rdd = flightRdd.
filter(line=> line(14).toInt > 1500).map(line=> (line(7),1))
>>> val tailModelRdd = airplanesRdd.map(line=> (line(0),line(4)))
>>> flight15Rdd.join(tailModelRdd).
map{case (a,(b,c))=> (c,b)}.reduceByKey((a,b)=> a+b).
map(pair => pair.swap).sortByKe