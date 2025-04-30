import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

abstract class Livestock {
    protected static final Logger logger = LogManager.getLogger(Livestock.class);
    String name;
    int age;

    public Livestock(String name, int age) {
        this.name = name;
        this.age = age;
        logger.info("Shine torol nemegdlee: ner={}, nas={}", name, age);
    }

    abstract String makeSound();

    String makeSound(int volume) {
        logger.debug("{} is making sound with volume {}", name, volume);
        return makeSound() + "(Volume: " + volume + ")";
    }

    void graze() {
        logger.info("{} haana bain ve?", name);
        System.out.println(name + " talbaid belchine.");
    }

    void graze(String food) {
        logger.info("{} is grazing on {}", name, food);
        System.out.println(name + " " + food + "iig belchine");
    }
}

interface WorkRole {
    String performTask();
}

class Horse extends Livestock implements WorkRole {
    private static final Logger logger = LogManager.getLogger(Horse.class);

    public Horse(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        logger.debug("{} (Horse) is making sound", name);
        return "Yntsgaana";
    }

    @Override
    public String performTask() {
        logger.info("{} (Horse) is performing task", name);
        return "Mori talbaid unalgad hereglegdene";
    }
}

class Sheep extends Livestock {
    private static final Logger logger = LogManager.getLogger(Sheep.class);

    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        logger.debug("{} (Sheep) is making sound", name);
        return "Maa";
    }
}

class Camel extends Livestock implements WorkRole {
    private static final Logger logger = LogManager.getLogger(Camel.class);

    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        logger.debug("{} (Camel) is making sound", name);
        return "Builna";
    }

    @Override
    public String performTask() {
        logger.info("{} (Camel) is performing task", name);
        return "Temee goviin teevert haerglegdene";
    }
}

class Goat extends Livestock implements WorkRole {
    private static final Logger logger = LogManager.getLogger(Goat.class);

    public Goat(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        logger.debug("{} (Goat) is making sound", name);
        return "mai";
    }

    @Override
    public String performTask() {
        logger.info("{} (Goat) is performing task", name);
        return "suu bolon noos nooluuriin uuregtei";
    }
}

class Cow extends Livestock {
    private static final Logger logger = LogManager.getLogger(Cow.class);

    public Cow(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        logger.debug("{} (Cow) is making sound", name);
        return "Moorno";
    }
}

class Herd {
    private static final Logger logger = LogManager.getLogger(Herd.class);
    ArrayList<Livestock> livestock = new ArrayList<>();

    void addLivestock(Livestock animal) {
        logger.info("Added livestock to herd: {}", animal.name);
        livestock.add(animal);
    }

    void dailyRoutine() {
        logger.info("Running daily routine for all livestock");
        for (Livestock animal : livestock) {
            System.out.println(animal.name + ": " + animal.makeSound());
            if (animal instanceof WorkRole) {
                System.out.println(((WorkRole) animal).performTask());
            }
        }
    }
}

public class NomadLivestockDemo {
    private static final Logger logger = LogManager.getLogger(NomadLivestockDemo.class);

    public static void main(String[] args) {
        logger.info("Programm ajillaj baina...");

        Livestock[] animals = {
            new Horse("Mori", 4),
            new Sheep("Honi", 6),
            new Camel("Temee", 5),
            new Goat("Ymaa", 3),
            new Cow("Vher", 7)
        };

        for (Livestock a : animals) {
            a.graze();
        }

        for (Livestock a : animals) {
            System.out.println(a.name + "\t: " + a.makeSound(10));
        }

        logger.info("Programm ajillaj duuslaa.");
    }
}
