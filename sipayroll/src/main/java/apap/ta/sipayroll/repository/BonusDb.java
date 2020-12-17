package apap.ta.sipayroll.repository;

import apap.ta.sipayroll.model.BonusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.ta.sipayroll.model.GajiModel;

import java.util.List;


@Repository
public interface BonusDb extends JpaRepository<BonusModel,Integer> {
    List<BonusModel> findByGaji(GajiModel gaji);
}
