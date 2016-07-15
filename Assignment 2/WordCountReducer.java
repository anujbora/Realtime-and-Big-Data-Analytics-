import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable>
{
	public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException
	{
		long tokenCount = 0L;
		
		for (LongWritable value : values) 
		{
			tokenCount = tokenCount + value.get();
		}
		
		context.write(key, new LongWritable(tokenCount));
	}
}