package apap.ta.sipayroll.service;
import apap.ta.sipayroll.rest.Setting;
import apap.ta.sipayroll.service.RekruitmenRestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import javax.transaction.Transactional;

@Service
@Transactional
public class RekruitmenRestServiceImpl implements RekruitmenRestService {

    private final WebClient webClient;
    public RekruitmenRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient= webClientBuilder.baseUrl("http://sirekrutmen.herokuapp.com").build();
    }


    @Override
    public String postRek(String divisi, String posisi,
                          String jumlah, String jenis){
        JSONObject obj = new JSONObject();
        obj.put("divisi", divisi);
        obj.put("posisi", posisi);
        obj.put("jumlah", jumlah);
        obj.put("jenis", jenis);
        String jsonFinal = obj.toString();
        return this.webClient.post().uri("/api/v1/lowongan").header("Content-Type", "application/json").syncBody(jsonFinal).retrieve().bodyToMono(String.class).block();
    }


}