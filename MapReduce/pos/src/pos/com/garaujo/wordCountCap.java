package pos.com.garaujo;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.conf.Configuration;


public class wordCountCap extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		String input, output;
		if (args.length == 2) {
			input = args[0];
			output = args[1];
		} else {
			System.err.println("Incorrect number of arguments.  Expected: input output");
			return -1;
		}
		Configuration conf = new Configuration();

		@SuppressWarnings("deprecation")
		Job job = new Job(conf, "wordCountCap");
		//Job job = new Job(getConf());
		job.setJarByClass(wordCountCap.class);
		job.setJobName(this.getClass().getName());

		//FileInputFormat.setInputPaths(job, new Path(input));
		//FileOutputFormat.setOutputPath(job, new Path(output));

		job.setMapperClass(exec01Mapper.class);
		job.setReducerClass(exec01Reduce.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		// define input path to job
		//Path input_dir = new Path("hdfs://localhost:8020/user/cloudera/input");
		Path input_dir = new Path(input);

		FileInputFormat.addInputPath(job, input_dir);

		// define output path to job
		//Path output_dir = new Path("hdfs://localhost:8020/user/cloudera/output");
		Path output_dir = new Path(output);

		FileOutputFormat.setOutputPath(job, output_dir);

		boolean success = job.waitForCompletion(true);
		return success ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		wordCountCap driver = new wordCountCap();
		int exitCode = ToolRunner.run(driver, args);
		System.exit(exitCode);
	}
}