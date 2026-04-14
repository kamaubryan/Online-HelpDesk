package Online.Help.Desk.Repository;

import Online.Help.Desk.Model.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("statusRepository")
@Transactional
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
