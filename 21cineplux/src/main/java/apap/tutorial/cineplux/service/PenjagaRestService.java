package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.rest.PenjagaDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;
//import apap.tutorial.cineplux.rest.PenjagaDetail;

import java.util.List;

public interface PenjagaRestService {
    void createPenjaga(PenjagaModel penjaga);
    List<PenjagaModel> retrieveListPenjaga();
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
    void updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate);
    void deletePenjaga(Long noPenjaga);
}
