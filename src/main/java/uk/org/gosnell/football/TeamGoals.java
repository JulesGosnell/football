package uk.org.gosnell.football;

/**
 * Immutably associate a football team [name] with a number of goals.
 * 
 * @author jules
 *
 */
public class TeamGoals {

	private final String team;
    private final int goals;
    
    public TeamGoals(String team, int goals) {
        this.team = team;
        this.goals = goals;
    }

	public String getTeam() {
		return team;
	}

	public int getGoals() {
		return goals;
	}
	
	// IDE generated:
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goals;
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamGoals other = (TeamGoals) obj;
		if (goals != other.goals)
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

}