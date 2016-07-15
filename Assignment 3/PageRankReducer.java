import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class PageRankReducer extends Reducer<Text, Text, Text, Text>
{
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{		
		Float PR = 0.0f;
		String ValueString = "";
		String Outlinks = "";
		
		for (Text value : values) 
		{			
			ValueString = value.toString();
			if ( ValueString.contains("#"))
			{
				PR = PR + Float.parseFloat(ValueString.split("#")[1]);
			}
			else
			{
				Outlinks = ValueString;
			}			
		}
		context.write(key, new Text(Outlinks + " " + PR.toString()));
	}
}