from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("wordcount2")
sc = SparkContext(conf=conf)
textData = sc.textFile("/child-parent关系表.txt")
splitData = textData.map(lambda line: line.split(","))
parent_kid = splitData.map(lambda line: (line[1], line[0]))
kid_parent = splitData.map(lambda line: (line[0], line[1]))
joinRDD = kid_parent.join(parent_kid)
grand_kid = joinRDD.map(lambda line: (line[1][0], line[1][1])).groupByKey().mapValues(list).sortByKey()

grand_kid.repartition(1).saveAsTextFile("/result2")