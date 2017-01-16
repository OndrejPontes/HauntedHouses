package cz.muni.fi.pa165.sampledata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.AbilityService;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MonikaMociarikova
 */

@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {



    @Autowired
    private AbilityService abilityService;

    @Autowired
    private GhostService ghostService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private HauntingService hauntingService;


    @Override
    @SuppressWarnings("unused")
    public void loadData() throws IOException {

        Ability invisibility = ability("Invisibility", "The power that causes the ghost to become completely transparent to all forms of vision.");
        Ability overshadowing = ability("Overshadowing", "The power to take over another living (or sometimes not living things) body. Can be resisted by strong will power to an extent.");
        Ability duplication = ability("Duplication", "The ability of a ghost to make exact copies of themself, each possessing its personality and powers.");
        Ability teleportation = ability("Teleportation", "The power to move from place to place by thought.");
        Ability telekinesis = ability("Telekinesis", "Arguably the most powerful power, the power that allows ghosts to make objects move, float or break at will; can be restricted to certain objects.");
        Ability sizeChanging = ability("Size changing", "Very powerful ghosts can make themselves bigger and smaller.");

        House sturdival = house("Sturdivant Hall", "Selma, Alabama", getDate(10,12,2016), "Built in 1856 in the Greek Revival style, this beautiful antebellum mansion was bought in 1864 by John McGee Parkman.  In the years after the Civil War, Parkman was arrested and imprisoned for cotton speculation.  While in prison, Parkman attempted to escape but was shot and killed in the process.  When his wife was forced to sell their house a few years after his death, his ghost began to appear regularly throughout the house and grounds, where it is still seen to this day.  People often report hearing windows and doors being opened and shut when no one else is in the house, as well as doors that close behind people and lock on their own.  The apparitions of two little girls are also frequently seen, though their identities remain unknown.");
        House whaley = house("The Whaley house", "San Diego, California", getDate(20,4,1966), "The mid-19th century house. Part of the house was once rented out to the County of San Diego for use as a courtroom…which may explain the appearance of several unidentified ghosts within the house.  Apart from these unnamed apparitions, the original owner, Thomas Whaley, his wife, one of their children, a little girl, and a convict are repeatedly seen within the house.  The house was apparently haunted as soon as it was built, as the spirit of a man who had been convicted and hanged on the site took up residence in the house upon its completion.  The Whaley apparitions are often seen engaged in the normal activities of their former day to day lives.  Doors have been known to close and lock on their own, and footsteps are often heard throughout the house, along with music and the crying of a baby.");
        House octagon = house("The Octagon house", "Washington D.C.", getDate(15,9,1942), "Completed in 1801, this former mansion is one of the most historic in the nation.  Built for Colonel John Tayloe III, it was briefly the site of the French Embassy during the War of 1812, as well as the temporary residence of President Madison, who signed the Treaty of Ghent in its central parlor.  Today, the building is used by the American Institute of Architects as a museum, but it has also made quite a name for itself as a center for paranormal activity, as far back as the mid-19th century.  The central staircase is a major hotspot for the supernatural, as footsteps are often heard, along with the saddened voice of a woman.  Doors have been locked only to suddenly be found standing wide open.  Lights turn on and off on their own, and footsteps – and even faint footprints! – have been reported throughout the building, and objects often move without human interference.");
        House william = house("William Kehoe House", "Savvanah, Georgia", getDate(24,12,1892), "Formerly the home of William Kehoe and his family, this 1892 house later became a school, a funeral home, and today is operated as a historic inn.  The Kehoe family, however, seems to have remained in residence long after their deaths, going about their usual routines while also interacting with guests and staff.  Mrs. Kehoe has often been seen sitting at a desk, writing, or sitting on the beds of sleeping guests.  Mr. Kehoe has been seen throughout the house as well, and on one occasion opened all of the exterior locked doors on the first floor…simultaneously.  The young twin boys of the Kehoe’s, who died in a childhood accident, have also been seen roaming throughout the house, and their noisy footsteps heard as they run across the upper floors.");
        House noHouse = house("No house", "Anywhere", null, "Ghosts in this house have not chosen a house to haunt in yet...but soon they will...");

        List<Ability> abilitiesOfWhiteLady = new ArrayList<Ability>();
        abilitiesOfWhiteLady.add(teleportation);
        abilitiesOfWhiteLady.add(sizeChanging);

        List<Ability> abilitiesOfMaryAndMirror = new ArrayList<Ability>();
        abilitiesOfMaryAndMirror.add(invisibility);
        abilitiesOfMaryAndMirror.add(telekinesis);

        List<Ability> abilitiesOfNightmare = new ArrayList<Ability>();
        abilitiesOfNightmare.add(overshadowing);
        abilitiesOfNightmare.add(telekinesis);
        abilitiesOfNightmare.add(teleportation);
        abilitiesOfNightmare.add(sizeChanging);


        Calendar timeFrom = Calendar.getInstance();
        timeFrom.set(Calendar.HOUR_OF_DAY, 20);
        timeFrom.set(Calendar.MINUTE, 0);
        timeFrom.set(Calendar.SECOND, 0);
        Calendar timeTo = Calendar.getInstance();
        timeTo.set(Calendar.HOUR_OF_DAY, 23);
        timeTo.set(Calendar.MINUTE, 0);
        timeTo.set(Calendar.SECOND, 0);

        Ghost whiteLady = ghost("The Wihte Lady", "A woman in white with long black hair and face either completely blank or obscured by blood usually standing in the middle of the road", timeFrom.getTime(), timeTo.getTime(), whaley, abilitiesOfWhiteLady);

        timeTo.set(Calendar.MINUTE, 30);
        Ghost nightmare = ghost("Nightmare ghost", "This horrible ghost does not let you sleep calm, he visits you at night, when you are sleeping and causes you worst nightmares!",timeFrom.getTime(), timeTo.getTime(), sturdival, abilitiesOfNightmare);

        timeFrom.set(Calendar.HOUR_OF_DAY, 23);
        timeFrom.set(Calendar.MINUTE, 50);
        timeTo.set(Calendar.MINUTE, 59);
        timeTo.set(Calendar.SECOND, 59);
        Ghost mary = ghost("Bloody Mary", "Young girl all covered with blood that haunts at midnight", timeFrom.getTime(), timeTo.getTime(), whaley, abilitiesOfMaryAndMirror );

        timeFrom.set(Calendar.HOUR_OF_DAY, 10);
        timeFrom.set(Calendar.MINUTE, 0);
        timeTo.set(Calendar.HOUR_OF_DAY, 19);
        timeTo.set(Calendar.MINUTE, 19);
        timeTo.set(Calendar.SECOND, 19);
        Ghost mirror = ghost("Mirror ghost", "If you hear story about him, you will never ever look in the mirror again...", timeFrom.getTime(), timeTo.getTime(), octagon, abilitiesOfMaryAndMirror);

        List<Ghost> ghostsForh1 = new ArrayList<Ghost>();
        ghostsForh1.add(whiteLady);
        ghostsForh1.add(mary);

        List<Ghost> ghostsForh2 = new ArrayList<Ghost>();
        ghostsForh2.add(nightmare);

        List<Ghost> ghostsForh3 = new ArrayList<Ghost>();
        ghostsForh3.add(mirror);

        Haunting h1 = haunting(getDate(16,12,2016), 3, whaley, ghostsForh1);
        Haunting h2 = haunting(getDate(16,12,2016), 10, sturdival, ghostsForh2);
        Haunting h3 = haunting(getDate(17,12,2016), 55, octagon, ghostsForh3);
    }



    private Ability ability(String name, String description) throws IOException{
        Ability a = new Ability();
        a.setName(name);
        a.setDescription(description);
        abilityService.create(a);
        return a;
    }

    private Ghost ghost(String name, String description, Date hauntsFrom, Date hauntsTo, House hauntedHouse, List<Ability> abilities) throws IOException {
        Ghost g = new Ghost();
        g.setName(name);
        g.setDescription(description);
        g.setHauntsFrom(hauntsFrom);
        g.setHauntsTo(hauntsTo);
        g.setHauntedHouse(hauntedHouse);
        g.setAbilities(abilities);
        ghostService.create(g);
        return g;
    }

    private House house(String name, String address, Date hauntingFrom, String history) throws IOException {
        House h = new House();
        h.setName(name);
        h.setAddress(address);
        h.setHauntingFrom(hauntingFrom);
        h.setHistory(history);
        houseService.create(h);
        return h;
    }

    private Haunting haunting(Date date, int numberOfPeoplePresent, House hauntedHouse, List<Ghost> ghosts) throws IOException {
        Haunting h = new Haunting();
        h.setDate(date);
        h.setNumberOfPeoplePresent(numberOfPeoplePresent);
        h.setHauntedHouse(hauntedHouse);
        h.setGhosts(ghosts);
        hauntingService.create(h);
        return h;
    }

    private Date getDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.YEAR, year );
        cal.set( Calendar.MONTH, month );
        cal.set( Calendar.DAY_OF_MONTH, day );
        return new Date(cal.getTime().getTime());
    }

    private Date getTime(int hour, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minutes);
        return new Date(cal.getTime().getTime());
    }

}
