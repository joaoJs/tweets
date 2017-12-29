package twitter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {
    
    public static void main(String[] args) {
        final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
        final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
        final Instant d4 = Instant.parse("2016-02-17T11:30:00Z");
        final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", d1);
        final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes @hype", d2);
        final Tweet tweet6 = new Tweet(6, "Honnan", "All my friends @joe and @kevin", d4);
        final Tweet tweet5 = new Tweet(5, "Marichellis", "Under the see @123fish!", d4);
        getMentionedUsers(Arrays.asList(tweet5, tweet6));
        Timespan t = getTimespan(Arrays.asList(tweet1, tweet2, tweet6));
        System.out.println(t.getStart());
        System.out.println(t.getEnd());
    }

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
        assert tweets.get(0).getTimestamp() != null : "first tweets.timestamp should not be null";
        assert tweets.get(tweets.size() - 1).getTimestamp() != null : "last tweets.timestamp should not be null";
        assert tweets.size() >= 2 : "tweets should have at list two entries";
        
        final Instant d1 = Instant.parse(tweets.get(0).getTimestamp().toString());
        final Instant d2 = Instant.parse(tweets.get(tweets.size() - 1).getTimestamp().toString());
        
        Timespan res = new Timespan(d1,d2);
        return res;
     
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        
        Set<String> usernames = new HashSet<>();
        
        for (Tweet t : tweets) {
                String[] words = t.getText().split("\\s");
                for (String w : words) {
                    if (w.startsWith("@")) {
                        String username = w.substring(1);
                        if (isValid(username)) {
                            System.out.println(username);
                            usernames.add(username);
                        }
                     }
                }
 
        }
        
        return usernames;
    }
    
    
    public static boolean isValid(String username) {
        Pattern p = Pattern.compile("[^A-Za-z_-]");
        Matcher m = p.matcher(username);
        return m.find() == false;
    }
    

    /* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
