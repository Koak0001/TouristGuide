package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;
import tourism.model.TouristAttraction.Tags;



import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        touristAttractions = new ArrayList<>();
        EnumSet<TouristAttraction.Tags> tags1 = EnumSet.of(Tags.OUTDOORS, Tags.FAMILY);
        TouristAttraction attraction1 = new TouristAttraction("The Blue Planet", tags1,"Copenhagen","Northern Europe’s largest aquarium showcasing stunning sea life in Copenhagen.","Experience the world under the sea as you discover majestic hammerhead sharks, secretive octopi and graceful rays at Northern Europe’s largest aquarium, Den Blå Planet (The Blue Planet) in Copenhagen.");
        attraction1.setImagePath("/images/Den_Bl_Planet1.jpg");
        addTouristAttraction(attraction1);

        EnumSet<TouristAttraction.Tags> tags2 = EnumSet.of(Tags.OUTDOORS, Tags.FAMILY, Tags.SCENIC, Tags.ADVENTURE);
        TouristAttraction attraction2 = new TouristAttraction("GoBoat Copenhagen",tags2,"Copenhagen","Unique harbor exploration in Copenhagen with GoBoat rental.", "Experience Copenhagen from a completely new perspective and explore the harbour at your own pace with GoBoat. You don’t need any certification or sailing experience to drive a boat - just come aboard! ");
        attraction2.setImagePath("/images/GoBoat_1.jpg");
        addTouristAttraction(attraction2);

        EnumSet<TouristAttraction.Tags> tags3 = EnumSet.of(Tags.FOOD, Tags.FAMILY);
        TouristAttraction attraction3 = new TouristAttraction("Torvehallerne",tags3,"Copenhagen","Copenhagen's culinary gem, offering global delicacies and fresh produce.", "Torvehallerne is one of Copenhagen's gems for locals and tourists alike. You can find speciality goods, fresh vegetables and exquisite little food bars where you can get specialities from all over the world.");
        attraction3.setImagePath("/images/Torvehallen1.jpg");
        addTouristAttraction(attraction3);

        EnumSet<Tags> tags4 = EnumSet.of(Tags.CULTURE, Tags.ART);
        TouristAttraction attraction4 = new TouristAttraction("Arken", tags4,"Ishøj", "Discover modern art at Arken, a must-visit museum near Copenhagen.","Immerse yourself in the vibrant world of contemporary art at Arken, showcasing innovative works from renowned Danish and international artists.");
        addTouristAttraction(attraction4);

        EnumSet<TouristAttraction.Tags> tags5 = EnumSet.of(Tags.ART, Tags.CULTURE, Tags.SCENIC);
        TouristAttraction attraction5 = new TouristAttraction("Louisiana Museum of Modern Art", tags5, "Humlebæk", "Immerse yourself in contemporary art at Louisiana, a renowned museum.", "Explore the beautiful surroundings of Louisiana Museum of Modern Art while discovering a diverse collection of contemporary artworks from around the world.");
        addTouristAttraction(attraction5);

    }

    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
    }

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

    public void updateTouristAttraction(TouristAttraction updatedAttraction) {
        for (int i = 0; i < touristAttractions.size(); i++) {
            if (touristAttractions.get(i).getName().equalsIgnoreCase(updatedAttraction.getName())) {
                touristAttractions.set(i, updatedAttraction);
                return;
            }
        }
        throw new IllegalArgumentException("Tourist Attraction with name  not found");
    }

    public boolean deleteTouristAttraction(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                touristAttractions.remove(attraction);
                return true;
            }
        }
        return false;
    }

    public String getTouristAttractionDescriptionByName(String name) { //TODO DO I NEED THIS? does it even work?
        for (TouristAttraction attraction : touristAttractions)
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction.getDescription();
            }
        return "description not found for: " + name;
    }
}