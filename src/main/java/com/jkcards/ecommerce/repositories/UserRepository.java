package com.jkcards.ecommerce.repositories;

import com.jkcards.ecommerce.entities.User;
import com.jkcards.ecommerce.projection.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(nativeQuery = true, value = """
			SELECT tb_user.email AS username, tb_user.password, tb_roles.id AS roleId, tb_roles.authority
			FROM tb_user
			INNER JOIN tb_user_roles ON tb_user.id = tb_user_roles.user_id
			INNER JOIN tb_roles ON tb_roles.id = tb_user_roles.roles_id
			WHERE tb_user.email = :email
		""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
}
