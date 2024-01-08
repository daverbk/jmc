public class Main {

    public static void main(String[] args) {
        Team<BaseballPlayer> phillies = new Team<>("Philadelphia Phillies");
        Team<BaseballPlayer> astros = new Team<>("Houston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();

        Team<FootballPlayer> afc = new Team<>("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        afc.listTeamMembers();
    }

    public static void scoreResult(Team team1, int t1Score,
                                   Team team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
