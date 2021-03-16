import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NbaTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        NbaTest nba = new NbaTest();
        nba.exc(bf);
    }
    String resultSheet1 = "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
            + "Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
            + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,"
            + "Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,Boston Celtics 112 Philadelphia 76ers 95,"
            + "Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,"
            + "Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,"
            + "Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,";
    String resultSheet2 = "San Antonio Spurs 111 Houston Rockets 86,Chicago Bulls 103 Dallas Mavericks 102,Minnesota Timberwolves 112 Milwaukee Bucks 108,"
            + "New Orleans Pelicans 93 Miami Heat 90,Boston Celtics 81 Philadelphia 76ers 65,Detroit Pistons 115 Atlanta Hawks 87,"
            + "Toronto Raptors 92 Washington Wizards 82,Orlando Magic 86 Memphis Grizzlies 76,Los Angeles Clippers 115 Portland Trail Blazers 109,"
            + "Los Angeles Lakers 97 Golden State Warriors 136,Utah Jazz 98 Denver Nuggets 78,Boston Celtics 99 New York Knicks 85,"
            + "Indiana Pacers 98 Charlotte Hornets 86,Dallas Mavericks 87 Phoenix Suns 99,Atlanta Hawks 81 Memphis Grizzlies 82,"
            + "Miami Heat 110 Washington Wizards 105,Detroit Pistons 94 Charlotte Hornets 99,Orlando Magic 110 New Orleans Pelicans 107,"
            + "Los Angeles Clippers 130 Golden State Warriors 95,Utah Jazz 102 Oklahoma City Thunder 113,San Antonio Spurs 84 Phoenix Suns 104,"
            + "Chicago Bulls 103 Indiana Pacers 94,Milwaukee Bucks 106 Minnesota Timberwolves 88,Los Angeles Lakers 104 Portland Trail Blazers 102,"
            + "Houston Rockets 120 New Orleans Pelicans 100,Boston Celtics 111 Brooklyn Nets 105,Charlotte Hornets 94 Chicago Bulls 86,Cleveland Cavaliers 103 Dallas Mavericks 97";
    String teams = "Los Angeles Clippers,Dallas Mavericks,New York Knicks,NYK,Atlanta Hawks,Indiana Pacers,Memphis Grizzlies,"
            + "Los Angeles Lakers,Minnesota Timberwolves,Phoenix Suns,Portland Trail Blazers,New Orleans Pelicans,"
            + "Sacramento Kings,Los Angeles Clippers,Houston Rockets,Denver Nuggets,Cleveland Cavaliers,Milwaukee Bucks,"
            + "Oklahoma City Thunder,San Antonio Spurs,Boston Celtics,Philadelphia 76ers,Brooklyn Nets,Chicago Bulls,"
            + "Detroit Pistons,Utah Jazz,Miami Heat,Charlotte Hornets,Toronto Raptors,Orlando Magic,Washington Wizards,"
            + "Golden State Warriors,Dallas Maver";
    String resultSheet3 = resultSheet1 + resultSheet2;
    int wins, draws, losses, scored, conceded, points = 0;


    public void exc(BufferedReader bf) throws IOException {
        String teamName = bf.readLine();
        String result;
        List<String> targetGamesList = new ArrayList<>();
        String[] games = resultSheet3.split(",");
        for (String s : games) {
            if (s.contains(teamName))
                targetGamesList.add(s);
        }
        if (targetGamesList.isEmpty()) {
            result = String.format("%s:This team didn't play!", teamName);
        } else {
            targetGamesList.forEach(game -> {
                String[] scores = game.split("(?<=[0-9])\\s(?=[a-zA-Z])");
                String[] s1 = scores[0].split("\\s+");
                int a = Integer.parseInt(s1[s1.length - 1]);
                String[] s2 = scores[1].split("\\s+");
                int b = Integer.parseInt(s2[s2.length - 1]);
                if (scores[0].startsWith(teamName)) {
                    if (a > b) {
                        wins++;
                        scored += a;
                        conceded += b;
                        points += 3;
                    } else if (a == b) {
                        draws++;
                        scored += a;
                        conceded += b;
                        points += 1;
                    } else {
                        losses++;
                        scored += a;
                        conceded += b;
                    }
                } else {
                    if (a > b) {
                        losses++;
                        scored += b;
                        conceded += a;
                    } else if (a == b) {
                        draws++;
                        scored += b;
                        conceded += a;
                        points += 1;
                    } else {
                        wins++;
                        scored += b;
                        conceded += a;
                        points += 3;
                    }
                }
            });
            result = String.format("%s:W=%s;D=%s;L=%s;Scored=%s;Conceded=%s;Points=%s",
                    teamName, wins, draws, losses, scored, conceded, points);
        }
        System.out.println(result);
    }
}