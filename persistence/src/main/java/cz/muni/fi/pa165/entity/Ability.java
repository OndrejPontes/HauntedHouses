package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.enums.GHOST_ABILITIES;

/**
 * @author vojtadavid
 */

public class Ability {
    private Long id;
    private String name;
    private String description;

    public Ability() {
    }

    public Ability(GHOST_ABILITIES ga){
        switch (ga){
            case  FLIGHT:
                this.name="FLIGHT";
                this.id = (long) 1;
                this.description="The power to defy gravity, and propel themselves through the air. Flight is one of the most basic powers. Most ghosts (if not all) can fly or float";
                break;
            case INTANGIBILITY:
                this.name="INTANGIBILITY";
                this.description="The power to phase through all forms of matter, but not always energy.";
                break;
            case INVISIBILITY:
                this.name="INVISIBILITY";
                this.description=" The power that causes the ghost to become completely transparent to all forms of vision.";
                break;
            case OVERSHADOWING:
                this.name="OVERSHADOWING";
                this.description="The power to take over another living (or sometimes not living things) body. Can be resisted by strong will power to an extent.";
                break;
            case GHOST_RAY:
                this.name="GHOST_RAY";
                this.description="The power allows the ghost to shoot a blast of ectoplasmic energy that usually comes out of the palm of it's hand. The color seems to determine its maximum power.";
                break;
            case SUPERNATURAL_PHYSICAL_ABILITIES:
                this.name="SUPERNATURAL_PHYSICAL_ABILITIES";
                this.description=" Many ghosts posses superhuman strength, speed, durability, agility, dexterity and reflexes.";
                break;
            case GOING_GHOST:
                this.name="GOING_GHOST";
                this.description="The power to change from human to ghost, only half ghosts have this power.";
                break;
            case GHOSTLY_WAIL:
                this.name="GHOSTLY_WAIL";
                break;
            case DUPLICATION:
                this.name="DUPLICATION";
                break;
            case TELEPORTATION:
                this.name="TELEPORTATION";
                break;
            case CRYOKINESIS:
                this.name="CRYOKINESIS";
                break;
            case SHAPE_SHIFTING:
                this.name="SHAPE_SHIFTING";
                break;
            case TELEKINESIS:
                this.name="TELEKINESIS";
                break;
            case SIZE_CHANGING:
                this.name="SIZE_CHANGING";
                break;
            case GHOST_PORTAL_CREATION:
                this.name="GHOST_PORTAL_CREATION";
                break;
            case GHOST_SHIELD:
                this.name="GHOST_SHIELD";
                break;
            case GHOST_STINGER:
                this.name="GHOST_STINGER";
                break;
        }
    }

    public Ability(Long id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
