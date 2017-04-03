package pos.com.garaujo;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;



public class MapperPath extends Mapper<Object, Text, Text, IntWritable>{
   
   private final static IntWritable one = new IntWritable(1);
   private Text word = new Text();
     
   public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
     Path filename = ((FileSplit)context.getInputSplit()).getPath();
     
     StringTokenizer itr = new StringTokenizer(value.toString());
     while (itr.hasMoreTokens()) {
       word.set(itr.nextToken().toUpperCase()+" "+ filename);
       context.write(word, one);
     }
   }
 }
