package apap.ta.sipayroll.service;

import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

public interface RekruitmenRestService {
    String postRek(String divisi, String posisi,
                    String jumlah, String jenis);
}
