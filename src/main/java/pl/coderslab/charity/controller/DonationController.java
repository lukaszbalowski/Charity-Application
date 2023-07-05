package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    @RequestMapping("/form")
    public String formAction(){
        return "form";
    }


    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @Autowired
    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categories);
        model.addAttribute("institutions", institutions);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("donation") Donation donation) {
        donationRepository.save(donation);
        return "form-confirmation";
    }


}
