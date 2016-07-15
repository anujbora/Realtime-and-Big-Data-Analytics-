Write a MapReduce program that runs in Hadoop and does the following (you must work independently):

a. Searches for all of the following strings in the input text file (you can provide these as parameters, or hardcode them):
    hackathon, Dec, Chicago, Java

b. Accepts a small input file to be searched containing lines of the form: Date,Time,Name,Tweet      		
    Here is the exact data to type into your input file:

  9-Dec-14,5:00PM,‏#Hackatopia,Tribeca Film Hackathon: Code As A New Language For Content Creators
  28-Oct-14,7:00PM,‏#NYCHadoop,Hadoop-NYC Strata/Hadoop World Meetup at AppNexus NYC
  31-Dec-14,3:00PM,‏#Hackatopia,Designers, Developers, Doers, don't miss this upcoming Chicago hackathon

c. The Mapper code will search for all of the strings in the input file.

d. The Reducer code will output the number of tweets that contained each string. Using the example above, the results will be:

	hackathon 2
	Dec 2
	Chicago 1
	Java 0