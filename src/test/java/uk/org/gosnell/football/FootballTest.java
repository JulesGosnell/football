package uk.org.gosnell.football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Test;

public class FootballTest {

    private static final String DATA_DIR = "src/main/resources";
    private static final String DATA_FILE = "football.dat";
    
    private static final int TEAM_NAME = 2;
    private static final int GOALS_FOR = 7;
    private static final int GOALS_AGAINST = 9;

    public class TeamGoals {
        private String team;
        private int goals;
        
        public TeamGoals(String team, int goals) {
            this.team = team;
            this.goals = goals;
        }
    }
    
    @Test
    public void test() {
        try(final Stream<String> lines = Files.lines(Paths.get(DATA_DIR, DATA_FILE))) {
                final Optional<String> result = lines.
                    map(line -> line.split("\\s+")).
                    filter(row -> row.length == 11).
                    map(row -> new TeamGoals(row[TEAM_NAME],
                                             Math.abs(Integer.parseInt(row[GOALS_FOR]) -
                                                      Integer.parseInt(row[GOALS_AGAINST])))).
                    min((l, r) -> Integer.compare(l.goals, r.goals)).
                    map(teamGoals -> teamGoals.team);
                
                System.out.println(result.orElse("no team") + " had the smallest goal difference");
            } catch (IOException e) {
            System.err.println("ERROR: unexpected problem");
            e.printStackTrace();
        }
    }
}
