package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.service.FilmService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BaseController {

    @Qualifier("filmServiceImpl")
    @Autowired
    FilmService filmService;

    @GetMapping("/")
    private String home(Model model) {
        List<FilmModel> listFilm = filmService.getListFilm();
        int jumlahFilm = listFilm.size();
        model.addAttribute("jumlahFilm", jumlahFilm);
        return "home";
    }
}
