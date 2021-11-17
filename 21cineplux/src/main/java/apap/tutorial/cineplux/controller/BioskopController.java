package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @Qualifier("filmServiceImpl")
    @Autowired
    FilmService filmService;

    private int tempRow = 0;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model){
        List<FilmModel> listFilm = filmService.getListFilm();
        model.addAttribute("listFilm", listFilm);
        model.addAttribute("row", tempRow);
        model.addAttribute("bioskop", new BioskopModel());

        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        String userRole = getUserRole();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if(bioskop == null) {
            model.addAttribute("noBioskop", noBioskop);
            return "error-page-bioskop";
        }
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        List<FilmModel> listFilm = bioskop.getListFilm();

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listFilm", listFilm);
        model.addAttribute("listPenjaga", listPenjaga);
        model.addAttribute("userRole", userRole);
        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if(bioskop == null) {
            model.addAttribute("noBioskop", noBioskop);
            return "error-page-bioskop";
        }
        model.addAttribute("bioskop", bioskop);
        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.updateBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping("/bioskop/deleteBioskop/{noBioskop}")
    public String deleteBioskop(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if(bioskop == null) {
            model.addAttribute("noBioskop", noBioskop);
            return "error-page-bioskop";
        }
        if (bioskop.getListPenjaga().size() != 0) {
            model.addAttribute("noBioskop", noBioskop);
            return "not-changeable-penjagaNotNull";
        }
        if (bioskopService.checkBioskopIsOpen(noBioskop)) {
            model.addAttribute("noBioskop", noBioskop);
            return "not-changeable";
        }
        bioskopService.deleteBioskop(bioskop);
        model.addAttribute("noBioskop", noBioskop);

        return "delete-bioskop";
    }

    @PostMapping("/bioskop/tambahrow")
    public String tambahRow(Model model
    ) {
        tempRow++;
        if (tempRow < 0) {
            tempRow = 0;
        }
        return addBioskopForm(model);
    }

    @PostMapping("/bioskop/hapusrow")
    public String hapusRow(Model model
    ) {
        tempRow--;
        if (tempRow <= 0) {
            tempRow = 0;
        }
        return addBioskopForm(model);
    }

    public String getUserRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().toString().replace("[", "").replace("]","");
    }
}
