package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;
import tourism.model.TouristAttraction.Tags;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

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
    @PostMapping("/add") //TODO UPDATE FROM ResponseEntity
    public ResponseEntity<Void> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addTouristAttraction(attraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/update") //TODO UPDATE FROM ResponseEntity
    public ResponseEntity<Void> updateAttraction(@RequestParam String name, @RequestBody TouristAttraction updatedAttraction) {
        touristService.updateTouristAttraction(name, updatedAttraction);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/delete/{name}") //TODO UPDATE FROM ResponseEntity
    public ResponseEntity<Void> deleteAttraction(@PathVariable String name) {
        boolean deleted = touristService.deleteTouristAttraction(name);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{name}/tags")
    public String getAttractionTagsByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        if (attraction == null) {
            return "attractionNotFound"; //TODO CREATE HTML PAGE
        }
        List<String> tagNames = attraction.getTags().stream()
                .map(Tags::getTagName)
                .collect(Collectors.toList());
        model.addAttribute("tagNames", tagNames);
        return "tags";
    }
}
