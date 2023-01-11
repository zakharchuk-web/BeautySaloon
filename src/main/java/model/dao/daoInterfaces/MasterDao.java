package model.dao.daoInterfaces;

import dto.Master;
import dto.Role;

public interface MasterDao extends Dao<Master, Long> {
    Long findRoleId(Role role);

    Master findByEmail(String email);

    void updateDescription(String description);
}
