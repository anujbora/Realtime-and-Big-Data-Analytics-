import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PageRankMapper extends Mapper<LongWritable, Text, Text, Text> 
{	
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException 
    {
		String StringLine = value.toString();
		String[] StringArr = StringLine.split(" ");
		int StringArrSize = StringArr.length;
		Float PR = 0.0f;
		String OutLinks = "";		
		for (int index=1; index< StringArrSize - 1; index++)
		{
			PR = Float.parseFloat(StringArr[StringArrSize-1]) / (StringArrSize - 2);

			context.write(new Text(StringArr[index]), new Text(StringArr[0] + "#" + PR.toString()));

			System.out.println("Key=" + StringArr[index] + " Value=" + StringArr[0] + " #" + PR.toString());
			
			OutLinks.concat(StringArr[index]+ " ");
			
			OutLinks += StringArr[index] + " ";
			
		}
		context.write(new Text(StringArr[0]), new Text(OutLinks.toString().trim()));
		System.out.println("Key="+StringArr[0] + " Value=" + OutLinks.toString());	
    }	    
}