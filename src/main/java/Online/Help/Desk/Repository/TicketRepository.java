package Online.Help.Desk.Repository;

import Online.Help.Desk.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ticketRepository")
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Ticket findById(int id);

    List<Ticket> findByAssignedToId(int id);
}
