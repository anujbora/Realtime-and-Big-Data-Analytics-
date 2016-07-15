import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> 
{
	@Override	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException 
	{
		String line = value.toString();
				
        // Search String
		String SearchStrings = "hackathon Dec Chicago Java";
		String[] SearchStringsARR = SearchStrings.split(" ");
				
		String SearchToken = "";
				
		for (int index=0; index< SearchStringsARR.length; index++)
		{
			// Ignore spaces and convert all to lower case
			SearchToken = SearchStringsARR[index].trim().toLowerCase();
					
			// Search the token in the line, if present then set value as 1 else 0
			context.write(new Text(SearchToken), line.toLowerCase().contains(SearchToken) ? new LongWritable(1) : new LongWritable(0));
		}
	}	    	 
}