package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public String getAllAttractions(Model model) {
        List<TouristAttraction> attractions = touristService.getAllTouristAttractions();
        model.addAttribute("attractions", attractions);
        return "attractionList" ;
    }
    @GetMapping("/{name}")
    public String getAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        model.addAttribute("attraction", attraction);
        return "attraction";
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addTouristAttraction(attraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<Void> updateAttraction(@RequestParam String name, @RequestBody TouristAttraction updatedAttraction) {
        touristService.updateTouristAttraction(name, updatedAttraction);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/delete/{name}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable String name) {
        boolean deleted = touristService.deleteTouristAttraction(name);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
