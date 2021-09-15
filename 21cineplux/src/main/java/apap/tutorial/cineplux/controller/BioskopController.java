package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambahkan objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //Return view template yang digunakan
        return "add-bioskop";
    }



    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add Variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        //Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = false) String idBioskop, Model model
    ) {

        if (idBioskop == null) {
            return nullParameterBioskop();
        }
        //Mendapatkan bioskop sesuai dengan idBioskop kalau tidak ada maka ke menu error
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if(bioskopModel == null) {
            return notFoundBioskop(idBioskop, model);
        }

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    @RequestMapping("/bioskop/view/id-bioskop/{idBioskop}")
    public String viewBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop, Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop kalau tidak ada maka ke menu error
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if(bioskopModel == null) {
            return notFoundBioskop(idBioskop, model);
        }

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    @RequestMapping("/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            @PathVariable(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop kalau tidak ada maka ke menu error
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if(bioskopModel == null) {
            return notFoundBioskop(idBioskop, model);
        }

        //Melakukan update jumlahStudio yang sesuai dengan idBioskop
        bioskopService.updateBioskop(idBioskop, jumlahStudio);

        //Memasukkan ke html agar tampilan terupdate terlihat
        model.addAttribute("idBioskop", idBioskop);
        model.addAttribute("jumlahStudio", jumlahStudio);


        return "update-bioskop";
    }

    @RequestMapping("/bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {

        //Melakukan update jumlahStudio yang sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if(bioskopModel == null) {
            return notFoundBioskop(idBioskop, model);
        }

        //Melakukan delete dengan parameter idBioskop
        bioskopService.deleteBioskop(idBioskop);

        //Memasukkan ke html agar tampilan terupdate terlihat
        model.addAttribute("idBioskop", idBioskop);

        return "delete-bioskop";
    }

    public String notFoundBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        //Memasukkan ke html agar tampilan terupdate terlihat
        model.addAttribute("idBioskop", idBioskop);

        return "not-found-bioskop";
    }

    @RequestMapping({"/bioskop/view/id-bioskop/", "/bioskop/delete/id-bioskop/",
            "/bioskop/update/id-bioskop/jumlah-studio/{jumlahStudio}"})
    public String nullParameterBioskop(
    ) {
        return "null-parameter-bioskop";
    }

    //source : https://www.danvega.dev/blog/2017/07/03/multiple-request-mappings-spring-boot/
}
