from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("wordcount1")
sc = SparkContext(conf=conf)

textData = sc.textFile("/???????.txt")
lines = textData.map(lambda line: line.split(","))
filtData = lines.filter(lambda line: line[3] == "??")
splitData = filtData.map(lambda line: (line[1], (int(line[4]), 1)))
countData = splitData.reduceByKey(lambda x, y: (x[0]+y[0], x[1]+y[1])).mapValues(lambda x: x[0]/x[1]).sortByKey()
n = []
res = countData.filter(lambda line: line[1] <= 100 and line[1] >= 90)
n.append(res.count())
res = countData.filter(lambda line: line[1] <= 89 and line[1] >= 80)
n.append(res.count())
res = countData.filter(lambda line: line[1] <= 79 and line[1] >= 70)
n.append(res.count())
res = countData.filter(lambda line: line[1] <= 69 and line[1] >= 60)
n.append(res.count())
res = countData.filter(lambda line: line[1] <= 59)
n.append(res.count())

countData.saveAsTextFile("/result1")
print('********************')
print(n)
print('********************')
