package uk.org.gosnell.football;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;

// TODO: I should write more tests here - particularly for error conditions,
// but that is out of scope for the current deliverable..


/**
 * Exercise Football class
 * 
 * @author jules
 *
 */
public class FootballTest {

    public static final String DATA_DIR = "src/test/resources";
    public static final String DATA_FILE = "football.dat";

    @Test
    public void test() throws IOException {
	assertEquals(Optional.of(new TeamGoals("Aston_Villa", 1)),
		     Football.extractMinimumTeamGoals("src/test/resources", "football.dat"));
    }

}
