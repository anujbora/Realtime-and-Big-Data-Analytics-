package twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class TwitterApplication 
{
    public static void main(String[] args) throws TwitterException, IOException
    {
      // Add your Consumer Key, Secret Key, Access token and Access Token Secret Key
    	ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
              .setOAuthConsumerKey("setOAuthConsumerKeyHere")
              .setOAuthConsumerSecret("setOAuthConsumerSecretHere")
              .setOAuthAccessToken("setOAuthAccessTokenHere")
              .setOAuthAccessTokenSecret("setOAuthAccessTokenSecretHere");

    	TwitterFactory tf = new TwitterFactory(cb.build());
      Twitter twitter = tf.getInstance();
      
      try 
      {
      	  String search_query;
          Scanner in = new Scanner(System.in); 
          System.out.println("Enter Search Query : ");
          search_query = in.nextLine();
          in.close();
      	  Query query = new Query(search_query);
          QueryResult result;
          result = twitter.search(query);
          List<Status> tweets = result.getTweets();
          PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
          for (Status tweet : tweets) 
          {
          	writer.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
          }
          writer.close();
          System.out.println("Tweet Results for search query '" + search_query + "' outputted to output.txt file");
          System.exit(0);
       } 
       catch (TwitterException te) 
       {
          te.printStackTrace();
          System.out.println("Failed to search tweets: " + te.getMessage());
          System.exit(-1);
       }
    }
}