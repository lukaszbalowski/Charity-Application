package pl.coderslab.charity.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionRepository InstitutionRepository;
    private final DonationRepository donationRepository;


    public HomeController(InstitutionRepository InstitutionRepository, DonationRepository donationRepository) {
        this.InstitutionRepository = InstitutionRepository;
        this.donationRepository = donationRepository;

    }
    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions = InstitutionRepository.findAll();
        model.addAttribute("institutions", institutions);

        Integer sumOfBags = donationRepository.getSumOfBags();
        model.addAttribute("sumOfBags", sumOfBags);

        Integer sumOfDonations = donationRepository.getSumOfDonations();
        model.addAttribute("sumOfDonations", sumOfDonations);
        return "index";
    }
}
