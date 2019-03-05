package com.example.parsec.model;

import java.util.HashMap;
import java.util.Map;

public class Universe {

    private Map<Integer, System> systems = new HashMap();
    private int[][] map = new int[16][10];


    public static Universe generateDefaultUniverse() {
        Universe universe = new Universe();
        for(int i = 0; i < universe.map.length; i++) {
            for(int j = 0; j < universe.map[0].length; j++) {
                universe.map[i][j] = 0;
            }
        }


        // Othello
        System Othello = new System(1, "Othello", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(10,4));
        universe.addSystem(Othello);

        System Iago = new System(2, "Iago    ", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(11,4));
        universe.addSystem(Iago);

        System Emilia = new System(3, "Emilia", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(10,6));
        universe.addSystem(Emilia);


        // King Lear
        System Lear = new System(4, "Lear    ", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(13,4));
        universe.addSystem(Lear);

        System Cordelia = new System(5, "Cordelia", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(13,5));
        universe.addSystem(Cordelia);


        // Hamlet
        System Hamlet = new System(6, "Hamlet", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(10,2));
        universe.addSystem(Hamlet);

        System Claudius = new System(7, "Claudius", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(11,2));
        universe.addSystem(Claudius);

        System Laertes = new System(8, "Laertes", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(9,2));
        universe.addSystem(Laertes);

        System Yorick = new System(9, "Yorick", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(8,3));
        universe.addSystem(Yorick);

        System Ophelia = new System(10, "Ophelia", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(11,3));
        universe.addSystem(Ophelia);


        // Julius Caesar
        System Caesar = new System(11, "Caesar", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(9,7));
        universe.addSystem(Caesar);

        System Brutus = new System(12, "Brutus", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(8,8));
        universe.addSystem(Brutus);

        System Cicero = new System(13, "Cicero", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(9,9));
        universe.addSystem(Cicero);


        // Romeo and Juliet
        System Montague = new System(14, "Montague", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(6,8));
        universe.addSystem(Montague);

        System Capulet = new System(15, "Capulet", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(4,8));
        universe.addSystem(Capulet);

        System Mercutio = new System(16, "Mercutio", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(5,9));
        universe.addSystem(Mercutio);

        System Benvolio = new System(17, "Benvolio", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(6,9));
        universe.addSystem(Benvolio);

        System Tybalt = new System(18, "Tybalt", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(5,7));
        universe.addSystem(Tybalt);


        // Macbeth
        System Macbeth = new System(19, "Macbeth", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(5,5));
        universe.addSystem(Macbeth);

        System Duncan = new System(20, "Duncan", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(5,3));
        universe.addSystem(Duncan);

        System Malcolm = new System(21, "Malcolm", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(5,2));
        universe.addSystem(Malcolm);


        // Antony and Cleopatra
        System Antony = new System(22, "Antony", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(4,4));
        universe.addSystem(Antony);

        System Cleopatra = new System(23, "Cleopatra", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(3,3));
        universe.addSystem(Cleopatra);


        // Henry V
        System HenryV = new System(24, "Henry V", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(8,5));
        universe.addSystem(HenryV);


        // The Taming of the Shrew
        System Petruchio = new System(25, "Petruchio", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(4,1));
        universe.addSystem(Petruchio);

        System Katherina = new System(26, "Katherina", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(6,1));
        universe.addSystem(Katherina);



        // The Merchant of Venice
        System Antonio = new System(27, "Antonio", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(1,5));
        universe.addSystem(Antonio);

        System Shylock = new System(28, "Shylock", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(3,5));
        universe.addSystem(Shylock);


        // Titus Andronicus
        System Titus = new System(28, "Titus", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(14,6));
        universe.addSystem(Titus);

        System Saturnius = new System(29, "Saturnius", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(15,7));
        universe.addSystem(Saturnius);

        System Lucius = new System(30, "Lucius", TechLevel.PRE_AGRICULTURE, Characteristics.NOSPECIALRESOURCES, new Coordinate(14,8));
        universe.addSystem(Lucius);


        return universe;
    }





    public void addSystem(System system) {
        if(map[system.getLocation().getX()][system.getLocation().getY()] != 0) {
            //System.out.println("System at that location already exists!");
        }
        else if(systems.containsKey(system.getId())) {
            //System.out.println("System with that ID already exists!");
        }
        else {
            systems.put(system.getId(), system);
            map[system.getLocation().getX()][system.getLocation().getY()] = system.getId();
        }
    }
    public void removeSystem(int id) {

    }
    public void removeSystem(Coordinate c) {

    }

    public String mapToString() {
        String s = "";
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0) {
                    s = s + "\t\t";
                }
                s = s + systems.get(map[i][j]).getName() + "\t";
            }
            s = s + "\n\n\n\n";
        }
        return s;
    }

    public String toString() {
        String s = "";

        for (Map.Entry<Integer, System> entry : systems.entrySet()) {
            System sys = entry.getValue();
            s = s + "Name: " + sys.getName() + "\t\tID: " + sys.getId() + "\t\tLocation: (" + sys.getLocation().getX() + ", " + sys.getLocation().getY()
                    + ")\t\tTech Level: " + sys.getTechLevel().toString() + "\t\tCharacteristic: " + sys.getCharacteristic().toString() + "\n";
        }

        return s;
    }

}
