package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.RoleModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleService {
    List<RoleModel> getListRole();
}
