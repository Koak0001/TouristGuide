package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }


    // Create
    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristRepository.addTouristAttraction(touristAttraction);
    }

    // Read
    public List<TouristAttraction> getAllTouristAttractions() {
        return touristRepository.getAllTouristAttractions();
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        return touristRepository.getTouristAttractionByName(name);
    }

    // Update
    public void updateTouristAttraction(String name, TouristAttraction updatedAttraction) {
        touristRepository.updateTouristAttraction(name, updatedAttraction);
    }

    // Delete
    public boolean deleteTouristAttraction(String name) {
        return touristRepository.deleteTouristAttraction(name);
    }
    public String getTouristAttractionDescription(String name){ //TODO DO I NEED THIS?
        return touristRepository.getTouristAttractionDescriptionByName(name);
    }

}
