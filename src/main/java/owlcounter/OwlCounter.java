package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OwlCounter {
    List<String> owls = readFromFile(Paths.get("src/test/resources/owls.txt"));

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    public int getNumberOfOwls(String country) {
        for (String line : owls) {
            if (line.split("=")[0].equals(country)) {
                return (Integer.parseInt(line.split("=")[1]));
            }
        }
       throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {
        int sum = 0;
        for (String line : owls) {
            sum += Integer.parseInt(line.split("=")[1]);
        }
        return sum;
    }
}
