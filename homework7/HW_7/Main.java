import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;

public class Main {
    private static Map<Integer, Long> addTimes = new HashMap<>();
    private static Map<Integer, Long> removeTimes = new HashMap<>();
    private static Map<Integer, Long> searchTimes = new HashMap<>();
    private static Map<Integer, Long> updateTimes = new HashMap<>();

    private static int addcounter = 0;
    private static int searchcounter = 0;
    private static int removecounter = 0;
      private static int updatecounter = 0;

    public static void main(String[] args) {
        StockDataManager manager = new StockDataManager();
        String inputFile = "input.txt";

        Random random = new Random();
        int NumberOfNodes = random.nextInt(20000) + 60000;
        writeToFile(inputFile, NumberOfNodes);

        performAnalysis(manager, inputFile);

        // Print average times for each operation
        System.out.printf("Average ADD time: %.2f %s\n", calculateAverage(addTimes), " ns");
        System.out.printf("Average REMOVE time: %.2f %s\n", calculateAverage(removeTimes), " ns");
        System.out.printf("Average SEARCH time: %.2f %s\n", calculateAverage(searchTimes), " ns");
        System.out.printf("Average UPDATE time: %.2f %s\n", calculateAverage(updateTimes), " ns");
        System.out.println("Number of nodes which is created: " + NumberOfNodes);

   SwingUtilities.invokeLater(() -> {
                String plotType = "scatter"; // Change to "scatter" for scatter plot
                GUIVisualization frame = new GUIVisualization(plotType,addTimes,"ADD"); // Create a new instance of GUIVisualization
                frame.setVisible(true); // Make the frame visible
            });

         SwingUtilities.invokeLater(() -> {
                String plotType = "scatter"; // Change to "scatter" for scatter plot
                GUIVisualization frame = new GUIVisualization(plotType,removeTimes,"REMOVE"); // Create a new instance of GUIVisualization
                frame.setVisible(true); // Make the frame visible
            });
             SwingUtilities.invokeLater(() -> {
                String plotType = "scatter"; // Change to "scatter" for scatter plot
                GUIVisualization frame = new GUIVisualization(plotType,searchTimes, "SEARCH"); // Create a new instance of GUIVisualization
                frame.setVisible(true); // Make the frame visible
            });  
               SwingUtilities.invokeLater(() -> {
                String plotType = "scatter"; // Change to "scatter" for scatter plot
                GUIVisualization frame = new GUIVisualization(plotType,updateTimes, "UPDATE"); // Create a new instance of GUIVisualization
                frame.setVisible(true); // Make the frame visible
            });   

    }

    public static void performAnalysis(StockDataManager manager, String inputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            long startTime, endTime;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                String command = tokens[0];

                switch (command) {
                    case "ADD":
                        startTime = System.nanoTime();
                        manager.addOrUpdateStock(tokens[1], Double.parseDouble(tokens[2]), Long.parseLong(tokens[3]), Long.parseLong(tokens[4]));
                        endTime = System.nanoTime();
                        addTimes.put(addcounter, endTime - startTime);
                        addcounter++;
                        break;
                    case "REMOVE":
                        startTime = System.nanoTime();
                        manager.removeStock(tokens[1]);
                        endTime = System.nanoTime();
                        removeTimes.put(removecounter, endTime - startTime);
                        removecounter++;
                        break;
                    case "SEARCH":
                        startTime = System.nanoTime();
                        manager.searchStock(tokens[1]);
                        endTime = System.nanoTime();
                        searchTimes.put(searchcounter, endTime - startTime);
                        searchcounter++;
                        break;
                   case "UPDATE":
                        startTime = System.nanoTime();
                        manager.updateStock(tokens[1],tokens[2],Double.parseDouble(tokens[3]), Long.parseLong(tokens[4]), Long.parseLong(tokens[5]));
                        endTime = System.nanoTime();
                        updateTimes.put(updatecounter, endTime - startTime);
                        updatecounter++;
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String filename, int numberOfNodes) {
        Random random = new Random();
        String randomName;
        String randomUpdateName;
        int randomInt;
        int randomArrayLetters;
        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        double randomPrice;
        long randomVolume;
        long randomMarketCap;

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < numberOfNodes; i++) {
                int randomProcess = random.nextInt(4);
                randomName = generateRandomString(random, arr, 3, 4);
                randomUpdateName = generateRandomString(random, arr, 3, 4);

                randomPrice = random.nextDouble() * 200000;
                randomVolume = Math.abs(random.nextLong() % 100000000);
                randomMarketCap = Math.abs(random.nextLong() % 100000000);

                switch (randomProcess) {
                    case 0:
                        writer.printf(Locale.US, "ADD %s %.2f %d %d\n", randomName, randomPrice, randomVolume, randomMarketCap);
                        break;
                    case 1:
                        writer.printf("REMOVE %s\n", randomName);
                        break;
                    case 2:
                        writer.printf("SEARCH %s\n", randomName);
                        break;
                    case 3:
                        writer.printf(Locale.US, "UPDATE %s %s %.2f %d %d\n", randomName, randomUpdateName, randomPrice, randomVolume, randomMarketCap);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomString(Random random, char[] arr, int minLength, int maxLength) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder name = new StringBuilder(length);
        for (int j = 0; j < length; j++) {
            name.append(arr[random.nextInt(arr.length)]);
        }
        return name.toString();
    }

    private static double calculateAverage(Map<Integer, Long> times) {
        if (times.isEmpty()) {
            return 0;
        }
        long sum = 0;
        for (Integer i: times.keySet()) {
            sum += times.get(i);
        }
        return (double) sum / times.size();
    }
}
