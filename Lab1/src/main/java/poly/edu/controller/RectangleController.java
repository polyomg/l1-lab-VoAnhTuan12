package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RectangleController {

    @GetMapping("/rectangle/form")
    public String rectangleForm() {
        return "rectangle";
    }

    @PostMapping("/rectangle/calc")
    public String calcRectangle(
            @RequestParam double width,
            @RequestParam double height,
            Model model) {

        double area = width * height;
        double perimeter = 2 * (width + height);

        model.addAttribute("width", width);
        model.addAttribute("height", height);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);

        return "rectangle";
    }
}