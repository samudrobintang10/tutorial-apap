package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BioskopInMemoryService implements BioskopService {

    private List<BioskopModel> listBioskop;

    //Constructor
    public BioskopInMemoryService() {
        listBioskop = new ArrayList<>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop) {
        listBioskop.add(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return listBioskop;
    }

    @Override
    public BioskopModel getBioskopByIdBioskop(String idBioskop) {
        for (BioskopModel bioskopModel : listBioskop) {
            if (idBioskop.equals(bioskopModel.getIdBioskop())) {
                return bioskopModel;
            }
        }
        return null;
    }

    @Override
    public void updateBioskop(String idBioskop, int jumlahStudio) {
        for (BioskopModel bioskopModel : listBioskop) {
            if (idBioskop.equals(bioskopModel.getIdBioskop())) {
                bioskopModel.setJumlahStudio(jumlahStudio);
            }
        }
    };

    @Override
    public void deleteBioskop(String idBioskop) {
        listBioskop.remove(getBioskopByIdBioskop(idBioskop));
    };
}
