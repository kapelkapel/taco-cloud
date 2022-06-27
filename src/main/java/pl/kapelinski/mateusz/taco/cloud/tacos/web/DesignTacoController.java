package pl.kapelinski.mateusz.taco.cloud.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kapelinski.mateusz.taco.cloud.tacos.model.Ingredient;
import pl.kapelinski.mateusz.taco.cloud.tacos.model.Ingredient.Type;
import pl.kapelinski.mateusz.taco.cloud.tacos.model.Taco;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "wheat", Type.WRAP),
                new Ingredient("COTO", "corn", Type.WRAP),
                new Ingredient("GRBF", "ground beef", Type.PROTEIN),
                new Ingredient("CARN", "chicken meat", Type.PROTEIN),
                new Ingredient("TMTO", "tomato pieces", Type.VEGGIES),
                new Ingredient("LETC", "lattuce", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SOUCE),
                new Ingredient("SRCR", "Sour cream", Type.SOUCE)
        );

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString
                    ().toLowerCase());
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(Taco taco){
        log.info("Processing project taco:"+taco);
        return "redirect:/orders/current";
    }
}
