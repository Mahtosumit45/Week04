package DesignVotingSystem;
import java.util.*;

public class VoteManager {
    private Map<String, Integer> voteCountMap = new HashMap<>();
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    public Map<String, Integer> getVoteResultsSorted() {
        return new TreeMap<>(voteCountMap);
    }

    public Map<String, Integer> getVotesInOrder() {
        return new LinkedHashMap<>(voteOrderMap);
    }

    public int getVotesForCandidate(String candidate) {
        return voteCountMap.getOrDefault(candidate, 0);
    }
}

