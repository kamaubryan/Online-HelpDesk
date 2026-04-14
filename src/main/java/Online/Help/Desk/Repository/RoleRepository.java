package Online.Help.Desk.Repository;


import Online.Help.Desk.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByRole(String role);
    Role findById(int Id);

}
