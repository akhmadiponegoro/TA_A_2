package apap.ta.sipayroll.repository;

import apap.ta.sipayroll.model.RoleModel;
import apap.ta.sipayroll.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findById(Long id);
}
