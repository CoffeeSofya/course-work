package com.course.work.cdrent.genre;

import com.course.work.cdrent.genre.dto.GenreCdDto;
import com.course.work.cdrent.genre.service.GenreCdService;
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
public class GenreCdController {
    private final GenreCdService service;

    @RequestMapping(value = {"/genre"}, method = RequestMethod.GET)
    public String listGenreCd(Model model) {
        model.addAttribute("genre", new GenreCdDto());
        model.addAttribute("listGenreCd", service.getAllGenreCd());
        return "/genre";
    }

    @RequestMapping(value = "/genres/add-genre", method = RequestMethod.POST)
    public String addGenreCd(@ModelAttribute("genre") @Valid GenreCdDto dto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            log.error("Возникла ошибка");
            model.addAttribute("listGenreCd", service.getAllGenreCd());
            return "/genre";
        }

        service.save(dto);
        return "redirect:/genre";
    }

    @RequestMapping(value = "/delete-genre/{id}", method = RequestMethod.GET)
    public String deleteGenreCd(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/genre";
    }

    @RequestMapping(value = "/edit-genre/{id}", method = RequestMethod.GET)
    public String editGenreCd(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", service.getById(id));
        model.addAttribute("listGenreCd", service.getAllGenreCd());
        model.addAttribute("genre", service.getById(id));
        return "/genre";
    }
}
