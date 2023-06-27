package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final pl.coderslab.charity.repository.InstitutionRepository InstitutionRepository;


    public HomeController(InstitutionRepository InstitutionRepository) {
        this.InstitutionRepository = InstitutionRepository;
    }
    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions = InstitutionRepository.findAll();
        model.addAttribute("institutions", institutions);
        return "index";
    }
}
