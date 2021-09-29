package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    void updatePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
    void deletePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNamaPenjaga(String namaPenjaga);
}
