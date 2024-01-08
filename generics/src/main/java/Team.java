import java.util.ArrayList;
import java.util.List;

public class Team<T> {
    private final String teamName;
    private final List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLoses = 0;
    private int totalTies = 0;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(T player) {
        if (!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }

    public void listTeamMembers() {
        System.out.println(teamName + " Roster:");
        System.out.println(teamMembers);
    }

    public int ranking() {
        return (totalLoses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {

        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins++;
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLoses++;
        }

        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
