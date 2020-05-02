package com.course.work.cdrent.rental;

import com.course.work.cdrent.rental.dto.RentalDto;
import com.course.work.cdrent.rental.service.RentalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class RentalController {
    private final RentalService service;

    @RequestMapping(value = {"/rental"}, method = RequestMethod.GET)
    public String listRental(Model model) {
        model.addAttribute("rental", new RentalDto());
        model.addAttribute("listRental", service.getAllRental());
        return "/rental";
    }

    @RequestMapping(value = "/rental/add-rental", method = RequestMethod.POST)
    public String addRental(@ModelAttribute("rental") @Valid RentalDto dto, BindingResult result) {
        if(result.hasErrors()) {
            log.error("Возникла ошибка");
            return "redirect:/rental";
        }

        service.save(dto);
        return "redirect:/rental";
    }

    @RequestMapping(value = "/delete-rental/{num_rental}", method = RequestMethod.GET)
    public String deleteRental(@PathVariable("num_rental") Integer numRental) {
        service.delete(numRental);
        return "redirect:/rental";
    }

    @RequestMapping(value = "/edit-rental/{num_rental}", method = RequestMethod.GET)
    public String editRental(@PathVariable("num_rental") Integer numRental, Model model) {
        model.addAttribute("num_rental", service.getById(numRental));
        model.addAttribute("listRental", service.getAllRental());
        model.addAttribute("rental", service.getById(numRental));
        return "/rental";
    }
}
