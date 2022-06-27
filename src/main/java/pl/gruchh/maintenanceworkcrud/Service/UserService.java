package pl.gruchh.maintenanceworkcrud.Service;

import pl.gruchh.maintenanceworkcrud.Repository.Entity.User;

public interface UserService {

    User loadUserByUsername(String username);
}
