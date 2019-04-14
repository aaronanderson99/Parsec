package com.example.parsec.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Universe.
 */
public class Universe {

    private final HashMap<Integer, System> systems = new HashMap<>();
    private final int[][] map = new int[16][10];
    private int starterSystem;

    /**
     * Generate default universe universe.
     *
     * @return the universe
     */
    public static Universe generateDefaultUniverse() {
        Universe universe = new Universe();
        universe.setStarterSystem();
        for(int i = 0; i < universe.map.length; i++) {
            for(int j = 0; j < universe.map[0].length; j++) {
                universe.map[i][j] = 0;
            }
        }


        // Othello
        System Othello = new System(1, "Othello", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(10,4));
        universe.addSystem(Othello);

        System Iago = new System(2, "Iago    ", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(11,4));
        universe.addSystem(Iago);

        System Emilia = new System(3, "Emilia", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(10,6));
        universe.addSystem(Emilia);


        // King Lear
        System Lear = new System(4, "Lear    ", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(13,4));
        universe.addSystem(Lear);

        System Cordelia = new System(5, "Cordelia", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(13,5));
        universe.addSystem(Cordelia);


        // Hamlet
        System Hamlet = new System(6, "Hamlet", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(10,2));
        universe.addSystem(Hamlet);

        System Claudius = new System(7, "Claudius", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(11,2));
        universe.addSystem(Claudius);

        System Laertes = new System(8, "Laertes", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(9,2));
        universe.addSystem(Laertes);

        System Yorick = new System(9, "Yorick", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(8,3));
        universe.addSystem(Yorick);

        System Ophelia = new System(10, "Ophelia", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(11,3));
        universe.addSystem(Ophelia);


        // Julius Caesar
        System Caesar = new System(11, "Caesar", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(9,7));
        universe.addSystem(Caesar);

        System Brutus = new System(12, "Brutus", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(8,8));
        universe.addSystem(Brutus);

        System Cicero = new System(13, "Cicero", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(9,9));
        universe.addSystem(Cicero);


        // Romeo and Juliet
        System Montague = new System(14, "Montague", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(6,8));
        universe.addSystem(Montague);

        System Capulet = new System(15, "Capulet", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(4,8));
        universe.addSystem(Capulet);

        System Mercutio = new System(16, "Mercutio", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(5,9));
        universe.addSystem(Mercutio);

        System Benvolio = new System(17, "Benvolio", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(6,9));
        universe.addSystem(Benvolio);

        System Tybalt = new System(18, "Tybalt", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(5,7));
        universe.addSystem(Tybalt);


        // Macbeth
        System Macbeth = new System(19, "Macbeth", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(5,5));
        universe.addSystem(Macbeth);

        System Duncan = new System(20, "Duncan", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(5,3));
        universe.addSystem(Duncan);

        System Malcolm = new System(21, "Malcolm", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(5,2));
        universe.addSystem(Malcolm);


        // Antony and Cleopatra
        System Antony = new System(22, "Antony", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(4,4));
        universe.addSystem(Antony);

        System Cleopatra = new System(23, "Cleopatra", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(3,3));
        universe.addSystem(Cleopatra);


        // Henry V
        System HenryV = new System(24, "Henry V", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(8,5));
        universe.addSystem(HenryV);


        // The Taming of the Shrew
        System Petruchio = new System(25, "Petruchio", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(4,1));
        universe.addSystem(Petruchio);

        System Katherina = new System(26, "Katherina", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(6,1));
        universe.addSystem(Katherina);



        // The Merchant of Venice
        System Antonio = new System(27, "Antonio", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(1,5));
        universe.addSystem(Antonio);

        System Shylock = new System(28, "Shylock", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(3,5));
        universe.addSystem(Shylock);


        // Titus Andronicus
        System Titus = new System(28, "Titus", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(14,6));
        universe.addSystem(Titus);

        System Saturnius = new System(29, "Saturnius", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(15,7));
        universe.addSystem(Saturnius);

        System Lucius = new System(30, "Lucius", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(14,8));
        universe.addSystem(Lucius);


        return universe;
    }


    /**
     * Add system.
     *
     * @param system the system
     */
    private void addSystem(System system) {
        if((map[system.getLocation().getX()][system.getLocation().getY()] == 0)
                && !(systems.containsKey(system.getId()))) {
            systems.put(system.getId(), system);
            map[system.getLocation().getX()][system.getLocation().getY()] = system.getId();
        }
    }

    /**
     * Gets system.
     *
     * @param id the id
     * @return the system
     */
    private System getSystem(int id) {
        return systems.get(id);
    }

    /**
     * Gets systems in range.
     *
     * @return the systems in range
     */
    public List<System> getSystemsInRange() {
        List<System> systems = new LinkedList<>();
        Ship ship = Game.getInstance().getPlayer().getShip();
        double range = ship.getFuel();
        int x = ship.getCurrentSystem().getLocation().getX();
        int y = ship.getCurrentSystem().getLocation().getY();

        for(int i = Math.max(x - (int)(range + 1), 0); i < Math.min(x + (int)(range + 1),
                map.length - 1); i++) {
            for(int j = Math.max(y - (int)(range + 1), 0); j < Math.min(y + (int)(range + 1),
                    map[0].length); j++) {
                if(map[i][j] != 0) {
                    double distance = Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
                    if (distance < range) {
                        getSystem(map[i][j]).setDistance(distance);
                        systems.add(getSystem(map[i][j]));
                    }
                }
            }
        }

        return systems;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Map.Entry<Integer, System> entry : systems.entrySet()) {
            System sys = entry.getValue();
            s.append("Name: ").append(sys.getName()).append("\t\tID: ").append(sys.getId())
                    .append("\t\tLocation: (").append(sys.getLocation().getX()).append(", ")
                    .append(sys.getLocation().getY()).append(")\t\tTech Level: ")
                    .append(sys.getTechLevel().toString()).append("\t\tCharacteristic: ")
                    .append(sys.getCharacteristic().toString()).append("\n");
        }

        return s.toString();
    }


    private void setStarterSystem() {
        this.starterSystem = 5;
    }

    /**
     * Returns the Starting System
     * @return the startingSystem object to return
     */
    public System getStarterSystem() {
        return getSystem(starterSystem);
    }

}
