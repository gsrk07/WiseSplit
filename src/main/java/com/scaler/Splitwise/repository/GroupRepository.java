package com.scaler.Splitwise.repository;

import com.scaler.Splitwise.models.Group;
import com.scaler.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

}
