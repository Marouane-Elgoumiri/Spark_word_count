
package lastSpark;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;


public class sparkwordcount {

    public static void main(String[] args) {
        new sparkwordcount().run("src/main/resources/input/testo.txt","src/main/resources/output");
        new sparkwordcount().run(args[0],args[1]);

    }

    private void run(String inputFilePath,String sourceResult) {
        SparkConf conf = new SparkConf();
        conf.setAppName(sparkwordcount.class.getName());
        conf.setMaster("local");
        String NewsourceResult = sourceResult + "_new";

        JavaSparkContext sc =new JavaSparkContext(conf);
        JavaRDD<String> file=sc.textFile(inputFilePath);
        JavaRDD<String> wordsFromFile = file.flatMap(content -> Arrays.asList(content.split(" ")).iterator());
        JavaPairRDD countData = wordsFromFile.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);
        countData.foreach(f->System.out.println(f));
        countData.saveAsTextFile(NewsourceResult);
        JavaPairRDD<String, Integer> counts= file.flatMap(l -> Arrays.asList(l.split(" ")).iterator()).mapToPair(w -> new Tuple2<>(w,1)).reduceByKey((a,b)-> a+b);
		counts.saveAsTextFile(NewsourceResult);

    }}