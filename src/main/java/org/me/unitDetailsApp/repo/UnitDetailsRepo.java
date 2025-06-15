package org.me.unitDetailsApp.repo;

import org.me.unitDetailsApp.entity.UnitDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitDetailsRepo extends JpaRepository<UnitDetails,String> {

}