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

    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristRepository.addTouristAttraction(touristAttraction);
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        return touristRepository.getAllTouristAttractions();
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        return touristRepository.getTouristAttractionByName(name);
    }
    public void updateTouristAttraction(TouristAttraction updatedAttraction) {
        touristRepository.updateTouristAttraction(updatedAttraction);
    }
    public boolean deleteTouristAttraction(String name) {
        return touristRepository.deleteTouristAttraction(name);
    }
    public String getTouristAttractionDescription(String name){ //TODO DO I NEED THIS?
        return touristRepository.getTouristAttractionDescriptionByName(name);
    }

}
