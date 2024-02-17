package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        touristAttractions = new ArrayList<>();
        // Add some sample attractions
        touristAttractions.add(new TouristAttraction("Den Blå Planet, National Aquarium Denmark", "Experience the world under the sea as you discover majestic hammerhead sharks, secretive octopi and graceful rays at Northern Europe’s largest aquarium, Den Blå Planet (The Blue Planet) in Copenhagen.","/images/Den_Bl_Planet1.jpg"));
        touristAttractions.add(new TouristAttraction("GoBoat Copenhagen", "Experience Copenhagen from a completely new perspective and explore the harbour at your own pace with GoBoat. You don’t need any certification or sailing experience to drive a boat - just come aboard! ", "/images/GoBoat_1.jpg"));
        touristAttractions.add(new TouristAttraction("Torvehallerne", "Torvehallerne is one of Copenhagen's gems for locals and tourists alike. You can find speciality goods, fresh vegetables and exquisite little food bars where you can get specialities from all over the world.", "/images/Torvehallen1.jpg"));
    }

    // Create
    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
    }

    // Read
    public List<TouristAttraction> getAllTouristAttractions() {
        return touristAttractions;
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        throw new IllegalArgumentException("Tourist Attraction with name " + name + " not found");
    }

    // Update
    public void updateTouristAttraction(String name, TouristAttraction updatedAttraction) {
        for (int i = 0; i < touristAttractions.size(); i++) {
            if (touristAttractions.get(i).getName().equalsIgnoreCase(name)) {
                touristAttractions.set(i, updatedAttraction);
                return;
            }
        }
        throw new IllegalArgumentException("Tourist Attraction with name " + name + " not found");
    }

    // Delete
// Delete
    public boolean deleteTouristAttraction(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                touristAttractions.remove(attraction);
                return true; // Deleted successfully
            }
        }
        return false; // Not found for deletion
    }

    public String getTouristAttractionDescriptionByName(String name) { //TODO DO I NEED THIS? does it even work?
        for (TouristAttraction attraction : touristAttractions)
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction.getDescription();
            }
        return "description not found for: " + name;
    }
}