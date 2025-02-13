package DesignVotingSystem;

public class Main {
    public static void main(String[] args) {
        VoteManager manager = new VoteManager();

        // Casting votes
        manager.castVote("Alice");
        manager.castVote("Bob");
        manager.castVote("Alice");
        manager.castVote("Charlie");
        manager.castVote("Bob");

        System.out.println("\nVotes in Order of Casting: " + manager.getVotesInOrder());
        System.out.println("\nVote Results Sorted by Candidate Name: " + manager.getVoteResultsSorted());
        System.out.println("\nVotes for Alice: " + manager.getVotesForCandidate("Alice"));
    }
}

