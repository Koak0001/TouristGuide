package tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;
import tourism.model.TouristAttraction.Tags;
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
    @GetMapping("/add")
    public String showAddAttractionForm(Model model) {
    TouristAttraction newAttraction = new TouristAttraction("", null, "", "", "");
    model.addAttribute("attraction", newAttraction);
    return "addAttraction";
}
    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute("attraction") TouristAttraction attraction) {
        touristService.addTouristAttraction(attraction);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/edit")
    public String showUpdateAttractionForm(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        model.addAttribute("attraction", attraction);
        return "editAttraction";
    }
    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute("attraction") TouristAttraction attraction) {
        touristService.updateTouristAttraction(attraction);
        return "redirect:/attractions";
    }

    @PostMapping("/delete/{name}")
    public String deleteAttraction(@PathVariable String name, Model model) {
        touristService.deleteTouristAttraction(name);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/tags")
    public String getAttractionTagsByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        if (attraction == null) {
            return "attractionNotFound";
        }
        List<String> tagNames = attraction.getTags().stream()
                .map(Tags::getTagName)
                .collect(Collectors.toList());
        model.addAttribute("attractionName", name);
        model.addAttribute("tagNames", tagNames);
        return "tags";
    }
}
