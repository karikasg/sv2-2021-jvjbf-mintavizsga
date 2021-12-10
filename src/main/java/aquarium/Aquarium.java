package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> aquarium = new ArrayList<>();
    public static final int CAPACITY = 20;

    public void addFish(Fish fish) {
        if (CAPACITY - (aquarium.size() * 5) < 5) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        } else {
            aquarium.add(fish);
        }
    }

    public void feed() {
        for (Fish fish : aquarium) {
            fish.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> removable = new ArrayList<>();
        for (Fish fish : aquarium) {
            if (fish.getWeight() > maxWeight) {
                removable.add(fish);
            }
        }
        aquarium.removeAll((removable));
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish fish : aquarium) {
            result.add(fish.getStatus());
        }
        return result;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int result = 0;
        for (Fish fish : aquarium) {
            if (fish.hasMemoryLoss()) {
                result++;
            }
        }
        return result;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish fish : aquarium) {
            if (color.equals(fish.getColor())) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        Fish minFish = aquarium.get(0);
        for (Fish fish : aquarium) {
            if (fish.getWeight() < minFish.getWeight()) {
                minFish = fish;
            }
        }
        return minFish;
    }
}
