

import java.io.*;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;


public class AllTimeHigh {
	
	public static class MapClass extends Mapper<LongWritable,Text,Text,DoubleWritable>
	   {
	      public void map(LongWritable key, Text value, Context context)
	      {	    	  
	         try{
	            String[] str = value.toString().split(",");	 
	            double high = Double.parseDouble(str[4]);
	            context.write(new Text(str[1]),new DoubleWritable(high));
	         }
	         catch(Exception e)
	         {
	            System.out.println(e.getMessage());
	         }
	      }
	   }
	
	  public static class ReduceClass extends Reducer<Text,DoubleWritable,Text,DoubleWritable>
	   {
		    private DoubleWritable result = new DoubleWritable();
		    
		    public void reduce(Text key, Iterable<DoubleWritable> values,Context context) throws IOException, InterruptedException {
		      double max = 0.00;
				
		         for (DoubleWritable val : values)
		         {       	
		        	if (val.get() > max) {
		        		max = val.get();
		        	}
		         }
		         
		      result.set(max);		      
		      context.write(key, result);
		      //context.write(key, new LongWritable(sum));
		      
		    }
	   }
	  public static void main(String[] args) throws Exception {
		    Configuration conf = new Configuration();
		    conf.set("mapreduce.output.textoutputformat.separator",",");
		    //conf.set("name", "value")
		    conf.set("mapreduce.input.fileinputformat.split.maxsize", "28311552");
		    Job job = Job.getInstance(conf, "All Time High Price for each stock");
		    job.setJarByClass(AllTimeHigh.class);
		    job.setMapperClass(MapClass.class);
		    job.setCombinerClass(ReduceClass.class);
		    job.setReducerClass(ReduceClass.class);
		    job.setNumReduceTasks(1);
		    job.setOutputKeyClass(Text.class);
		    job.setOutputValueClass(DoubleWritable.class);
		    FileInputFormat.addInputPath(job, new Path(args[0]));
		    FileOutputFormat.setOutputPath(job, new Path(args[1]));
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
		  }
}