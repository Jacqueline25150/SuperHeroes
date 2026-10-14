import java.util.Arrays;

// =======================================================
// Main Class: SuperheroRoster
// =======================================================
public class SuperheroRoster {

    public static void main(String[] args) {
        System.out.println("=== PART 1: PARALLEL ARRAYS MANAGEMENT ===");
        
        // 1. Declare and initialize parallel arrays for hero names, abilities, and power levels
        String[] heroNames = {"Spider-Man", "Iron Man", "Black Widow"};
        String[] abilities = {"Web-slinging", "Flying and high-tech armor", "Stealth and combat"};
        int[] powerLevels = {85, 90, 80};

        // 2. Print each hero's details using a loop
        System.out.println("Superhero List:");
        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Hero: " + heroNames[i] + " | Ability: " + abilities[i] + " | Power Level: " + powerLevels[i]);
        }

        // 3. Call the searchHero method to find a specific hero by name
        System.out.println("\nSearching for heroes:");
        searchHero(heroNames, abilities, powerLevels, "Iron Man");
        searchHero(heroNames, abilities, powerLevels, "Thor"); // Test case for not found

        // 4. Calculate and display the average power level
        double averagePower = calculateAveragePower(powerLevels);
        System.out.printf("\nAverage Superhero Power Level: %.2f\n", averagePower);


        System.out.println("\n=== PART 2: OBJECT-ORIENTED SUPERHERO ARRAY ===");

        // Create an array of Superhero objects and populate it
        Superhero[] heroObjects = new Superhero[3];
        heroObjects[0] = new Superhero("Spider-Man", "Web-slinging", 85);
        heroObjects[1] = new Superhero("Iron Man", "Flying and high-tech armor", 90);
        heroObjects[2] = new Superhero("Black Widow", "Stealth and combat", 80);

        // Display each object's details
        System.out.println("Superhero Object Roster:");
        for (Superhero hero : heroObjects) {
            hero.displayHero();
        }


        System.out.println("\n=== BONUS TASK: SORTING HEROES BY POWER LEVEL ===");
        // Sort and print the heroes from highest to lowest power level
        sortAndDisplayHeroesDescending(heroNames, abilities, powerLevels);
    }

    // =======================================================
    // Method: searchHero
    // =======================================================
    public static void searchHero(String[] names, String[] abilities, int[] powerLevels, String target) {
        boolean found = false;
        
        for (int i = 0; i < names.length; i++) {
            // Case-insensitive comparison for user friendliness
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("Found! -> Hero: " + names[i] + " | Ability: " + abilities[i] + " | Power Level: " + powerLevels[i]);
                found = true;
                break; // Stop searching once found
            }
        }
        
        if (!found) {
            System.out.println("Hero \"" + target + "\" not found in the roster.");
        }
    }

    // =======================================================
    // Method: calculateAveragePower
    // =======================================================
    public static double calculateAveragePower(int[] powerLevels) {
        if (powerLevels == null || powerLevels.length == 0) {
            return 0.0;
        }
        
        int sum = 0;
        for (int level : powerLevels) {
            sum += level;
        }
        
        // Cast to double to prevent integer division truncation
        return (double) sum / powerLevels.length;
    }

    // =======================================================
    // Bonus Method: Sort Parallel Arrays in Descending Order (Bubble Sort)
    // =======================================================
    public static void sortAndDisplayHeroesDescending(String[] names, String[] abilities, int[] powerLevels) {
        // Clone the original arrays so we don't accidentally modify the source data layout
        String[] sortedNames = names.clone();
        String[] sortedAbilities = abilities.clone();
        int[] sortedPowers = powerLevels.clone();

        // Implement a basic Bubble Sort to sort items in descending order
        int n = sortedPowers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements; swap if the next element is higher
                if (sortedPowers[j] < sortedPowers[j + 1]) {
                    // Swap power levels
                    int tempPower = sortedPowers[j];
                    sortedPowers[j] = sortedPowers[j + 1];
                    sortedPowers[j + 1] = tempPower;

                    // Swap corresponding names to keep parallel consistency
                    String tempName = sortedNames[j];
                    sortedNames[j] = sortedNames[j + 1];
                    sortedNames[j + 1] = tempName;

                    // Swap corresponding abilities
                    String tempAbility = sortedAbilities[j];
                    sortedAbilities[j] = sortedAbilities[j + 1];
                    sortedAbilities[j + 1] = tempAbility;
                }
            }
        }

        // Print sorted results
        System.out.println("Heroes Sorted by Power Level (Highest to Lowest):");
        for (int i = 0; i < sortedPowers.length; i++) {
            System.out.println((i + 1) + ". " + sortedNames[i] + " (Power: " + sortedPowers[i] + ") - " + sortedAbilities[i]);
        }
    }
}


// =======================================================
// Class: Superhero (Object Oriented Design)
// =======================================================
class Superhero {
    // Attributes
    private String name;
    private String ability;
    private int powerLevel;

    // Constructor to initialize name, ability, and powerLevel
    public Superhero(String name, String ability, int powerLevel) {
        this.name = name;
        this.ability = ability;
        this.powerLevel = powerLevel;
    }

    // Method: displayHero
    public void displayHero() {
        System.out.println("Hero Name: " + name + " | Primary Ability: " + ability + " | Power Status: " + powerLevel);
    }
}
