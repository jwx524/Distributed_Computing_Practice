import java.io.IOException;
import java.util.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount3 { 

  public static class TokenizerMapper 
       extends Mapper<Object, Text, Text, Text>{
    public void map(Object key, Text value, Context context)
        throws IOException, InterruptedException {
      String child = value.toString().split(",")[0];
      String parent = value.toString().split(",")[1];
      context.write(new Text(child), new Text("-" + parent));
      context.write(new Text(parent), new Text("+" + child));
    }
}
  
  public static class IntSumReducer 
       extends Reducer<Text,Text,Text,Text> {
    public void reduce(Text key, Iterable<Text> values, Context context)
        throws IOException, InterruptedException {
      ArrayList<Text> grandparent = new ArrayList<Text>();
      ArrayList<Text> grandchild = new ArrayList<Text>();
      for (Text t : values) {
        String s = t.toString();
        if (s.startsWith("-")) {
          grandparent.add(new Text(s.substring(1)));
        } else {
          grandchild.add(new Text(s.substring(1)));
        }
      }
      for (int i = 0; i < grandchild.size(); i++) {
        for (int j = 0; j < grandparent.size(); j++) {
          context.write(grandchild.get(i), grandparent.get(j));
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
    if (otherArgs.length < 2) {
      System.err.println("Usage: wordcount <in> [<in>...] <out>");
      System.exit(2);
    }
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount3.class);
    job.setMapperClass(TokenizerMapper.class);
    //job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);
    for (int i = 0; i < otherArgs.length - 1; ++i) {
      FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
    }
    FileOutputFormat.setOutputPath(job,
      new Path(otherArgs[otherArgs.length - 1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}