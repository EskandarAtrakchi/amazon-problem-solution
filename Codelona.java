import java.util.ArrayList;
import java.util.List;

public class TeamCounter {

    // Method to count valid teams
    public static int countTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {
        // Step 1: Filter the players based on their skill levels
        List<Integer> filteredSkills = new ArrayList<>();
        for (int skill : skills) {
            if (skill >= minLevel && skill <= maxLevel) {
                filteredSkills.add(skill);
            }
        }

        // Step 2: Generate all subsets and count valid teams
        return countValidTeams(filteredSkills, minPlayers);
    }

    // Helper method to count valid subsets (teams)
    private static int countValidTeams(List<Integer> filteredSkills, int minPlayers) {
        int n = filteredSkills.size();
        int validTeamCount = 0;

        // Step 3: Use bitmasking to generate all subsets
        // There are 2^n possible subsets of a list of size n
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(filteredSkills.get(j));
                }
            }
            // Check if the subset is a valid team
            if (subset.size() >= minPlayers) {
                validTeamCount++;
            }
        }
        return validTeamCount;
    }

    public static void main(String[] args) {
        // Example usage
        int[] skills = {12, 4, 6, 13, 5, 10};
        int minPlayers = 3;
        int minLevel = 4;
        int maxLevel = 10;

        int result = countTeams(skills, minPlayers, minLevel, maxLevel);
        System.out.println("Number of valid teams: " + result);  // Output should be 5
    }
}
