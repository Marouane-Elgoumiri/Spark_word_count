# Simple Word Count with Spark & Java

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Spark](https://img.shields.io/badge/Apache%20Spark-E25A1C.svg?style=for-the-badge&logo=Apache-Spark&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Intellij Idea](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
</div>

## Note:
### Reading input file and defining source result:

```java
  new sparkwordcount().run("src/main/resources/input/testo.txt","src/main/resources/output");
  new sparkwordcount().run(args[0],args[1]);
```

#### Creating the new source result:

```java
  String NewsourceResult = sourceResult + "_new";
```

#### save the *counts* and *countData*:

```java
  countData.saveAsTextFile(NewsourceResult);
  counts.saveAsTextFile(NewsourceResult);
```
![openSource](https://img.shields.io/badge/Open%20Source%20Initiative-3DA639.svg?style=for-the-badge&logo=Open-Source-Initiative&logoColor=white)
