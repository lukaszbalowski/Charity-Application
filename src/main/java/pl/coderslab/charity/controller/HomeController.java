package pl.coderslab.charity.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final pl.coderslab.charity.repository.InstitutionRepository InstitutionRepository;
    private final JdbcTemplate jdbcTemplate;


    public HomeController(InstitutionRepository InstitutionRepository, JdbcTemplate jdbcTemplate) {
        this.InstitutionRepository = InstitutionRepository;
        this.jdbcTemplate = jdbcTemplate;
    }
    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions = InstitutionRepository.findAll();
        model.addAttribute("institutions", institutions);

        Integer sumOfBags = jdbcTemplate.queryForObject("SELECT SUM(quantity) FROM donations", Integer.class);
        model.addAttribute("sumOfBags", sumOfBags);
        return "index";
    }
}
