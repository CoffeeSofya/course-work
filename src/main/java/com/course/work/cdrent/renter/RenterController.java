package com.course.work.cdrent.renter;

import com.course.work.cdrent.renter.dto.RenterDto;
import com.course.work.cdrent.renter.service.RenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class RenterController {
    private final RenterService service;

    @RequestMapping(value = {"/renter"}, method = RequestMethod.GET)
    public String listRenter(Model model) {
        model.addAttribute("renter", new RenterDto());
        model.addAttribute("listRenter", service.getAllRenter());
        return "/renter";
    }


    @RequestMapping(value = "/renters/add-renter", method = RequestMethod.POST)
    public String addRenter(@ModelAttribute("renter") @Valid RenterDto dto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            log.error("Возникла ошибка");
            model.addAttribute("listRenter", service.getAllRenter());
            return "/renter";
        }

        service.save(dto);
        return "redirect:/renter";
    }

    @RequestMapping(value = "/delete-renter/{numRenter}", method = RequestMethod.GET)
    public String deleteRenter(@PathVariable("numRenter") Integer numRenter) {
        service.delete(numRenter);
        return "redirect:/renter";
    }

    @RequestMapping(value = "/edit-renter/{numRenter}", method = RequestMethod.GET)
    public String editRenter(@PathVariable("numRenter") Integer numRenter, Model model) {
        model.addAttribute("numRenter", service.getById(numRenter));
        model.addAttribute("listRenter", service.getAllRenter());
        model.addAttribute("renter", service.getById(numRenter));
        return "/renter";
    }
}
