package twitter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SocialNetworkTest {

    /*
     * Testing strategy for getTimespan
     *
     *guessFollowsGraph()
     * Partition the inputs as follows:
     * tweet list is not empty, but nobody follows anyone
     * one user follows another user
     * one user follows multiple users
     * multiple users follow one or multiple users
     * 
     * 
     * influencers()
     * 
     * social network is empty
     * social network contains one influencers who is mentioned many times
     * social network contains multiple influencers
     * 
     */
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about @harry or @sahyl and @maria so much?", null);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", null);
    private static final Tweet tweet3 = new Tweet(3, "john", "is it reasonable to talk about @sahyl so much?", null);
    private static final Tweet tweet4 = new Tweet(4, "harry", "rivest talk in 30 minutes with @maria #hype", null);
    private static final Tweet tweet5 = new Tweet(5, "ana", "rivest talk is in 30 minutes with @maria #hype", null);
    
//    @Test(expected=AssertionError.class)
//    public void testAssertionsEnabled() {
//        assert false; // make sure assertions are enabled with VM argument: -ea
//    }
//    
//    @Test
//    public void testGuessFollowsGraphEmpty() {
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
//        
//        assertTrue("expected empty graph", followsGraph.isEmpty());
//    }
//    
//    @Test
//    public void testGuessFollowsGraphNone() {
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet2));
//        
//        assertTrue("expected empty graph", followsGraph.isEmpty());
//    }
//    
//    @Test
//    public void testGuessFollowsGraphOneUserFollowsOne() {
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet2, tweet3));
//        
//        assertTrue("expected one follower", followsGraph.size() == 1);
//    }
//    
//    @Test
//    public void testGuessFollowsGraphOneMultipleFollowers() {
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2, tweet3, tweet4));
//        
//        assertTrue("expected multiple followers", followsGraph.size() > 1);
//    }
//    
//    @Test
//    public void testInfluencersEmpty() {
//        Map<String, Set<String>> followsGraph = new HashMap<>();
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//        
//        assertTrue("expected empty list", influencers.isEmpty());
//    }
//    
//    @Test
//    public void testInfluencersOneName() {
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet4, tweet5));
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//        
//        assertTrue("expected one name", influencers.size() == 1);
//    }
//    
//    @Test
//    public void testInfluencersMultiple() {
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2, tweet3, tweet4, tweet5));
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//        
//        assertTrue("expected multiple influencers", influencers.size() > 1);
//    }
//    
    @Test
    public void testInfluencersMultipleDescendingOrder() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2, tweet3, tweet4, tweet5));
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        assertTrue("expected result in descending order", influencers.get(0).equals("maria"));
        assertTrue("expected result in descending order", influencers.get(1).equals("sahyl"));
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */


    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
