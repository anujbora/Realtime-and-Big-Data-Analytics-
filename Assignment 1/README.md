Detailed Assignment instructions:

a. Try out the Hadoop HDFS commands in your Hadoop environment, you will need this to do the assignment. 
    See this link, it’s a great reference: 
    http://hadoop.apache.org/docs/r2.6.0/hadoop-project-dist/hadoop-common/FileSystemShell.html
    Try this:
		hdfs dfs -ls /                            -- To see the contents of the top-level directory in HDFS
        hdfs dfs –ls                             -- To see the contents of your user directory
        hdfs dfs –mkdir myNewDir     -- To create a new directory named ‘myNewDir’ in your user directory
        hdfs dfs –ls                             -- To verify that you now have a directory called ‘myNewDir’
        hdfs dfs –rm –r myNewDir     -- To remove directory ‘myNewDir’
		hdfs dfs –ls                             -- To verify that you have successfully removed the directory called ‘myNewDir’

b. Read pp.17-27. 
    
    The MapReduce program that I would like you to run is in the book in Example 2-3, 2-4, and 2-5 (pp.22-26) - you don't have to write your own program, just use the book example. 

    The weather data that you must use is in the book example (just 5 lines in a file) - see middle of page 23. You will need to pad out the ‘…’ in the sample data with dummy data, or change the indexes in the program to make this work.

c. Type in the program and input the data as shown in Example 2-3, 2-4, and 2-5 in the book,run your program:
    hadoop jar yourJarFile.jar className </path/to/your/input/directory> </path/to/your/output/directory>
