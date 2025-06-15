package org.me.unitDetailsApp.entity;

import java.util.List;

public class UnitResponse {

    private UnitDetailsNav unitDetailsNav;
    private List<UnitDetails> unitDetails;

    public UnitResponse(UnitDetailsNav unitDetailsNav, List<UnitDetails> unitDetails) {
        this.unitDetailsNav = unitDetailsNav;
        this.unitDetails = unitDetails;
    }

    // Getters and setters (or use Lombok annotations like @Data for brevity)
    public UnitDetailsNav getUnitDetailsNav() {
        return unitDetailsNav;
    }

    public void setUnitDetailsNav(UnitDetailsNav unitDetailsNav) {
        this.unitDetailsNav = unitDetailsNav;
    }

    public List<UnitDetails> getUnitDetails() {
        return unitDetails;
    }

    public void setUnitDetails(List<UnitDetails> unitDetails) {
        this.unitDetails = unitDetails;
    }
}