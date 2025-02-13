package DesignVotingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class VoteManagerTest {
    private VoteManager manager;

    @BeforeEach
    void setUp() {
        manager = new VoteManager();
        manager.castVote("Alice");
        manager.castVote("Bob");
        manager.castVote("Alice");
        manager.castVote("Charlie");
        manager.castVote("Bob");
    }

    @Test
    void testVoteResultsSorted() {
        Map<String, Integer> sortedVotes = manager.getVoteResultsSorted();
        assertEquals(2, sortedVotes.get("Alice"));
        assertEquals(2, sortedVotes.get("Bob"));
        assertEquals(1, sortedVotes.get("Charlie"));
    }

    @Test
    void testVotesInOrder() {
        Map<String, Integer> orderedVotes = manager.getVotesInOrder();
        String firstCandidate = orderedVotes.keySet().iterator().next();
        assertEquals("Alice", firstCandidate); // First vote was for Alice
    }

    @Test
    void testGetVotesForCandidate() {
        assertEquals(2, manager.getVotesForCandidate("Alice"));
        assertEquals(2, manager.getVotesForCandidate("Bob"));
        assertEquals(1, manager.getVotesForCandidate("Charlie"));
        assertEquals(0, manager.getVotesForCandidate("Unknown")); // No votes
    }
}
