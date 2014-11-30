package uk.org.gosnell.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;


/**
 * Util[s] for extracting football teams and associated goal data from .dat files.
 * 
 * @author jules
 *
 */
public class Football {

	private static final int TEAM_NAME = 2;
	private static final int GOALS_FOR = 7;
	private static final int GOALS_AGAINST = 9;

	public static Optional<TeamGoals> extractMinimumTeamGoals(String dataDir, String dataFile) throws IOException {
		try(final Stream<String> lines = Files.lines(Paths.get(dataDir, dataFile))) {
			return lines.
					map(line -> line.split("\\s+")).
					filter(row -> row.length == 11).
					map(row -> new TeamGoals(row[TEAM_NAME],
							Math.abs(Integer.parseInt(row[GOALS_FOR]) -
									Integer.parseInt(row[GOALS_AGAINST])))).
									min((l, r) -> Integer.compare(l.getGoals(), r.getGoals()));

		}
	}

	public static void main(String[] args) {
		//TODO: error check arg format if this becomes main point of entry...
		
		final String dataDir = args[0];
		final String dataFile = args[1];
		try {
			System.out.println(extractMinimumTeamGoals(dataDir, dataFile).map(teamGoals -> teamGoals.getTeam()).orElse("no team") + " had the smallest goal difference");
		} catch (IOException e) {
			System.err.println("ERROR: unexpected problem extracting minimum team goals (" + dataDir + ", " + dataFile + "):");
			e.printStackTrace();
		}
	}
}
