package com.course.work.cdrent.cd;

import com.course.work.cdrent.cd.dto.CDDto;
import com.course.work.cdrent.cd.repository.CDRepository;
import com.course.work.cdrent.cd.service.CDService;
import com.course.work.cdrent.genre.entity.GenreCdEntity;
import com.course.work.cdrent.infocd.entity.InfoCdEntity;
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
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CDController {
    private final CDService service;

    private final CDRepository repository;

    @RequestMapping(value = {"/cd"}, method = RequestMethod.GET)
    public String listCD(Model model) {
        model.addAttribute("cd", new CDDto());
        model.addAttribute("listCD", service.getAllCD());
        return "/cd";
    }

    @RequestMapping(value = "/cds/add-cd", method = RequestMethod.POST)
    public String addCD(@ModelAttribute("cd") @Valid CDDto dto, BindingResult result) {
        if(result.hasErrors()) {
            log.error("Возникла ошибка");
            return "redirect:/edit-cd/" + dto.getNumCd();
        }

        service.save(dto);
        return "redirect:/cd";
    }

    @RequestMapping(value = "/delete-cd/{num_cd}", method = RequestMethod.GET)
    public String deleteCD(@PathVariable("num_cd") Integer numCd) {
        service.delete(numCd);
        return "redirect:/cd";
    }

    @RequestMapping(value = "edit-cd/{num_cd}", method = RequestMethod.GET)
    public String editCD(@PathVariable("num_cd") Integer numCd, Model model) {
        model.addAttribute("listCD", service.getAllCD());
        model.addAttribute("cd", service.getById(numCd));
        return "/cd";
    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String test() {
//        log.info("{}",repository.get());
//        return "/cd";
//    }
}
