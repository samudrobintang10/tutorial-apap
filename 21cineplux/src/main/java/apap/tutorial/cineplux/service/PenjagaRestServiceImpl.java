package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
//import apap.tutorial.cineplux.rest.PenjagaDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PenjagaRestServiceImpl implements PenjagaRestService {
    private final WebClient webClient;

    @Autowired
    private PenjagaDB penjagaDB;

    @Autowired
    private BioskopDB bioskopDB;

    @Override
    public void createPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public List<PenjagaModel> retrieveListPenjaga() {
        return penjagaDB.findAll();
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        BioskopModel bioskop = penjaga.getBioskop();

        if ((now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup()))) {
            penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
            penjaga.setJenisKelamin(penjagaUpdate.getJenisKelamin());
            penjaga.setBioskop(penjagaUpdate.getBioskop());

            penjagaDB.save(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still Open!");
        }
    }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        BioskopModel bioskop = penjaga.getBioskop();

        if ((now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup()))) {
            penjagaDB.delete(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still Open!");
        }
    }

    public PenjagaRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.agify.io/").build();
    }

    @Override
    public String prediksiUmurPenjaga(Long noPenjaga){
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        String[] namaPenjaga = penjaga.getNamaPenjaga().split(" ");
        ClientResponse response = this.webClient.get().uri("/?name=" + namaPenjaga[0]).exchange().block();
        return Objects.requireNonNull(Objects.requireNonNull(response).bodyToMono(JsonNode.class).block()).get("age").asText();
    }
}