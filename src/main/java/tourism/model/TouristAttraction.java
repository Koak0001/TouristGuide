package tourism.model;

import java.util.EnumSet;

public class TouristAttraction {
    private String name;
    private EnumSet<Tags> tags;
    private String city;
    private String description;
    private String descriptionLong;
    private String imagePath;

    public TouristAttraction(String name, EnumSet<Tags> tags, String city, String description, String descriptionLong) {
        this.name = name;
        this.tags = tags;
        this.city = city;
        this.description = description;
        this.descriptionLong = descriptionLong;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String getImagePath() {
        return imagePath;
    }
    public String getCity(){return city;}
    public String getDescriptionLong(){return descriptionLong;}
    public EnumSet<Tags> getTags() {
        return tags;
    }

    public enum Tags {
        FAMILY("Family"),
        FOOD("Food"),
        OUTDOORS("Outdoors"),
        ART("Art"),
        HISTORY("History"),
        CULTURE("Culture"),
        ADVENTURE("Adventure"),
        SCENIC("Scenic"),
        SHOPPING("Shopping");

        private final String tagName;

        Tags(String tagName) {
            this.tagName = tagName;
        }

        public String getTagName() {
            return tagName;
        }

    }
}
