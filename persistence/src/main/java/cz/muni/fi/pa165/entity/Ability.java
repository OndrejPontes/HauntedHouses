package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.enums.GHOST_ABILITIES;

/**
 * @author Vojta David
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
                this.id = (long) 2;
                this.description="The power to phase through all forms of matter, but not always energy.";
                break;
            case INVISIBILITY:
                this.name="INVISIBILITY";
                this.id = (long) 3;
                this.description=" The power that causes the ghost to become completely transparent to all forms of vision.";
                break;
            case OVERSHADOWING:
                this.name="OVERSHADOWING";
                this.id = (long) 4;
                this.description="The power to take over another living (or sometimes not living things) body. Can be resisted by strong will power to an extent.";
                break;
            case GHOST_RAY:
                this.name="GHOST_RAY";
                this.id = (long) 5;
                this.description="The power allows the ghost to shoot a blast of ectoplasmic energy that usually comes out of the palm of it's hand. The color seems to determine its maximum power.";
                break;
            case SUPERNATURAL_PHYSICAL_ABILITIES:
                this.name="SUPERNATURAL_PHYSICAL_ABILITIES";
                this.id = (long) 6;
                this.description=" Many ghosts posses superhuman strength, speed, durability, agility, dexterity and reflexes.";
                break;
            case GOING_GHOST:
                this.name="GOING_GHOST";
                this.id = (long) 7;
                this.description="The power to change from human to ghost, only half ghosts have this power.";
                break;
            case GHOSTLY_WAIL:
                this.name="GHOSTLY_WAIL";
                this.id = (long) 8;
                this.description="It allows the ghost to generate great sonic waves of ectoplasmic energy which destroy whatever they hit and more.";
                break;
            case DUPLICATION:
                this.name="DUPLICATION";
                this.id = (long) 9;
                this.description="The ability of a ghost to make exact copies of themself, each possessing its personality and powers.";
                break;
            case TELEPORTATION:
                this.name="TELEPORTATION";
                this.id = (long) 10;
                this.description="The power to move from place to place by thought.";
                break;
            case CRYOKINESIS:
                this.name="CRYOKINESIS";
                this.id = (long) 11;
                this.description="The power for ghosts to fire or radiate intense cold, it can also be used to detect ghosts.";
                break;
            case SHAPE_SHIFTING:
                this.name="SHAPE_SHIFTING";
                this.id = (long) 12;
                this.description="The power for a ghost to change its appearance, form or even characteristics.";
                break;
            case TELEKINESIS:
                this.name="TELEKINESIS";
                this.id = (long) 13;
                this.description="Arguably the most powerful power, the power that allows ghosts to make objects move, float or break at will; can be restricted to certain objects.";
                break;
            case SIZE_CHANGING:
                this.name="SIZE_CHANGING";
                this.id = (long) 14;
                this.description="Very powerful ghosts can make themselves bigger and smaller.";
                break;
            case GHOST_PORTAL_CREATION:
                this.name="GHOST_PORTAL_CREATION";
                this.id = (long) 15;
                this.description="A very rare power that allows ghosts to personally create portals between Earth and The Ghost Zone at will.";
                break;
            case GHOST_SHIELD:
                this.name="GHOST_SHIELD";
                this.id = (long) 16;
                this.description="Some ghosts can create a shield made out of Ectoplasmic Energy around themselves.";
                break;
            case GHOST_STINGER:
                this.name="GHOST_STINGER";
                this.id = (long) 17;
                this.description="The power to zap a being or object that the ghost is hold/touching/connected to something else that the energy can run through with ectoplasmic energy.";
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

    public Ability setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ability setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Ability setDescription(String description) {
        this.description = description;
        return this;
    }
}
