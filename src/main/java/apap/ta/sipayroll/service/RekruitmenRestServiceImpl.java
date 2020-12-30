package apap.ta.sipayroll.service;
import apap.ta.sipayroll.service.RekruitmenRestService;
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
    public Mono<String> postRekruitmen(MultiValueMap<String,String> data) {
        Mono<String> test = this.webClient.post().uri("/api/v1/lowongan").syncBody(data).retrieve().bodyToMono(String.class);
//        System.out.println("ini dari postman" + test.block());
        return test;
    }}