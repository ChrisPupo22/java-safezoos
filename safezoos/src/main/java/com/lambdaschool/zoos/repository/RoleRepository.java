package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM UserRoles WHERE userid = :userid AND roleid = :roleid")
    void deleteUserRoles(long userid,
                         long roleid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO UserRoles(userid, roleid) VALUES (:userid, :roleid)",
            nativeQuery = true)
    void insertUserRoles(long userid,
                         long roleid);


    Role findByNameIgnoreCase(String name);



}
