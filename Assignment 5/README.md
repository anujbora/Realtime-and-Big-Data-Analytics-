Pig Program
       
If you’re using the Quickstart VM, Pig is already installed. If you are not using the QVM, install Pig in your environment if it is not already there.
The homework is to write a Pig program that is equivalent to the MapReduce word search program you previously wrote. 

It is ok to use Grunt, but see if you can also write a Pig script and execute the script. 
Please submit your Pig program, input, and output to NYU Classes. Your program should do the following:
	
a. Search the given lines of input (see b. below) for these specific search strings:
     hackathon, Dec, Chicago, Java

b. Accept a small input file containing lines of the form: Date,Time,Name,Tweet      		
 Here is the exact data to type into your input file:

  9-Dec-14,5:00PM,‏#Hackatopia,Tribeca Film Hackathon: Code As A New Language For Content Creators
  28-Oct-14,7:00PM,‏#NYCHadoop,Hadoop-NYC Strata/Hadoop World Meetup at AppNexus NYC
  31-Dec-14,3:00PM,‏#Hackatopia,Designers, Developers, Doers, don't miss this upcoming Chicago hackathon

c. Search for all of the search terms in all lines of the input file. Matching is not case-sensitive.

d. For each search term, output the number of lines (tweets) that contained the search term. The results will be:
    Chicago 1
	Dec 2
	Java 0
	hackathon 2