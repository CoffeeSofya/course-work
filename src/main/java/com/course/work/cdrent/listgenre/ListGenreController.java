package com.course.work.cdrent.listgenre;

import com.course.work.cdrent.cd.service.CDService;
import com.course.work.cdrent.listgenre.dto.ListGenreDto;
import com.course.work.cdrent.listgenre.service.ListGenreService;
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
public class ListGenreController {
    private final ListGenreService service;
    private final CDService cdService;

    @RequestMapping(value = {"/list-genre"}, method = RequestMethod.GET)
    public String listListGenre(Model model) {
        model.addAttribute("list-genre", new ListGenreDto());
        model.addAttribute("listListGenre", service.getAllListGenre());
        return "/list-genre";
    }

    @RequestMapping(value = "/list-genre/add-list-genre", method = RequestMethod.POST)
    public String addListGenre(@ModelAttribute("list-genre") @Valid ListGenreDto dto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            log.error("Возникла ошибка");
            model.addAttribute("listListGenre", service.getAllListGenre());
            return "/list-genre";
        }

        service.save(dto);
        return "redirect:/list-genre";
    }

    @RequestMapping(value = "/delete-list-genre/{numGenre}", method = RequestMethod.GET)
    public String deleteListGenre(@PathVariable("numGenre") Integer numGenre) {
        service.delete(numGenre);
        return "redirect:/list-genre";
    }

    @RequestMapping(value = "/edit-list-genre/{numGenre}", method = RequestMethod.GET)
    public String editListGenre(@PathVariable("numGenre") Integer numGenre, Model model) {
        model.addAttribute("numGenre", service.getById(numGenre));
        model.addAttribute("listListGenre", service.getAllListGenre());
        model.addAttribute("list-genre", service.getById(numGenre));
        return "/list-genre";
    }

    @RequestMapping(value ="/get-list-cd/{numGenre}", method = RequestMethod.GET)
    public String getListGenres(@PathVariable("numGenre") Integer numGenre, Model model) {
        model.addAttribute("listListGenre", service.getAllListGenre());
        model.addAttribute("list-genre", service.getById(numGenre));
        model.addAttribute("listgenres", cdService.getCdForGenres(numGenre));
        return "/list-genre";
    }
}

