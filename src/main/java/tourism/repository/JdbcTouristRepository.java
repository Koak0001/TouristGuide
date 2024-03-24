package tourism.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.List;

@Repository
public class JdbcTouristRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTouristRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        String sql = "SELECT attraction_id, attractionName, TouristAttraction.description, description_long, City, picture_file FROM TouristAttraction";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            int attractionId = resultSet.getInt("attraction_id");
            String name = resultSet.getString("attractionName");
            String description = resultSet.getString("description");
            String descriptionLong = resultSet.getString("description_long");
            String city = resultSet.getString("City");
            String imagePath = resultSet.getString("picture_file"); // TODO Korrekt?
            return new TouristAttraction(attractionId, name, description, descriptionLong, city);
        }
        );
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        // Logic here
        return null; // Placeholder
    }

    public void addTouristAttraction(TouristAttraction touristAttraction) {
        // Logic here
    }

    public void updateTouristAttraction(TouristAttraction updatedAttraction) {
        // Logic here
    }

    public boolean deleteTouristAttraction(String name) {
     // Logic here
        return false; // Placeholder
    }
}
