package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PenjagaController {
    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("/penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping("/bioskop/updatePenjaga/{noPenjaga}")
    public String updatePenjagaForm(
            @PathVariable Long noPenjaga,
            Model model
    ) {
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        if (penjaga == null) {
            model.addAttribute("noPenjaga", noPenjaga);
            return "error-page-penjaga";
        }
        BioskopModel bioskop = penjaga.getBioskop();
        if (bioskopService.checkBioskopIsOpen(bioskop.getNoBioskop())) {
            model.addAttribute("noBioskop", bioskop.getNoBioskop());
            return "not-changeable";
        }
        model.addAttribute("penjaga", penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());

        return "form-update-penjaga";
    }

    @PostMapping("/bioskop/updatePenjaga")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        BioskopModel bioskop = penjaga.getBioskop();

        penjagaService.updatePenjaga(penjaga);
        model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-penjaga";
    }

    @PostMapping("/penjaga/delete")
    public String deletePenjagaSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        if (bioskopService.checkBioskopIsOpen(bioskop.getNoBioskop())) {
            model.addAttribute("noBioskop", bioskop.getNoBioskop());
            return "not-changeable";
        }
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        for (PenjagaModel penjaga: bioskop.getListPenjaga()) {
            penjagaService.deletePenjaga(penjaga);
        }
        return "delete-penjaga";
    }

    @GetMapping("/bioskop/deletePenjaga/{noPenjaga}")
    public String deletePenjaga(
            @PathVariable Long noPenjaga,
            Model model
    ) {
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        if (penjaga == null) {
            model.addAttribute("noPenjaga", noPenjaga);
            return "error-page-penjaga";
        }
        BioskopModel bioskop = penjaga.getBioskop();
        if (bioskopService.checkBioskopIsOpen(bioskop.getNoBioskop())) {
            model.addAttribute("noBioskop", bioskop.getNoBioskop());
            return "not-changeable";
        }
        penjagaService.deletePenjaga(penjaga);
        model.addAttribute("penjaga", penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());

        return "delete-penjaga";
    }


}
