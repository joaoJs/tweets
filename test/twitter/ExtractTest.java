package twitter;

import static org.junit.Assert.*;

/*
 * Testing strategy for getTimespan
 *
 * Partition the inputs as follows:
 * more than one user 
 * tweets.size() == 1;
 * tweets.timestamp == null;
 * 
 * Includes 1 because since Timespan calculates the interval between 2 endpoints, it requires 
 * more than one Tweet.
 * 
 */


/*
 * Testing strategy for getMentionedUsers()
 *
 * Partition the inputs as follows:
 * tweet.text is empty;
 * tweet.text contains an email.
 * Extract.getMentionedUsers().size() >= 2;
 * Extract.getMentionedUsers().size() == 1;
 * Extract.getMentionedUsers() contains characters other than
 * letters (A-Z or a-z), digits, underscore ("_"), or hyphen ("-").
 * 
 * 
 * Includes 1 because since Timespan calculates the interval between 2 endpoints, it requires 
 * more than one Tweet.
 * 
 */


import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ExtractTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * Make sure you have partitions.
     */
    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = null;
    private static final Instant d4 = Instant.parse("2016-02-17T11:30:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes @hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "bbitdiddle", "rivest talk in 30 minutes #jerry", null);
    private static final Tweet tweet4 = new Tweet(4, "Marilu", "rivest talk in 30 minutes. Email: johnatan@alyssa.com", d4);
    private static final Tweet tweet5 = new Tweet(5, "Marichellis", "Under the see @123fish!", d4);
    private static final Tweet tweet6 = new Tweet(6, "Honnan", "All my friends @joe and @kevin", d4);
    
    private static final List<Tweet> single = Arrays.asList(tweet1);
    private static final List<Tweet> zero = new ArrayList<Tweet>();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGetTimespanTwoTweets() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1, tweet2));
        
        assertEquals("expected start", d1, timespan.getStart());
        assertEquals("expected end", d2, timespan.getEnd());
    }
    
//    @Test
//    public void testGetTimespanZeroTweets() {
//        
//        assertEquals(0, Extract.getTimespan(zero));
//    }
    
//    @Test
//    public void testGetTimespanEmptyTimestamp() {
//        
//        assertEquals("tweets.timestamp should not be null", Extract.getTimespan(Arrays.asList(tweet1, tweet2, tweet3)));
//    }
    
    @Test
    public void testGetMentionedUsersNoMention() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet1));
        
        assertTrue("expected empty set", mentionedUsers.isEmpty());
    }
    
    @Test
    public void testGetMentionedUsersEmail() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet4));
        
        assertTrue("expected empty set when email included in text", mentionedUsers.isEmpty());
    }
    
    @Test
    public void testGetMentionedUsersWithMultipleUsers() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet6));
        
        assertTrue("expected two or more users", mentionedUsers.size() >= 2);
    }
    

    @Test
    public void testGetMentionedUsersWithIllegalCharacters() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet5));
        
        assertTrue("invalid username", mentionedUsers.isEmpty());
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * Extract class that follows the spec. It will be run against several staff
     * implementations of Extract, which will be done by overwriting
     * (temporarily) your version of Extract with the staff's version.
     * DO NOT strengthen the spec of Extract or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Extract, because that means you're testing a
     * stronger spec than Extract says. If you need such helper methods, define
     * them in a different class. If you only need them in this test class, then
     * keep them in this test class.
     */


    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */

}
