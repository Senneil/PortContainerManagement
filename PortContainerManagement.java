import java.util.ArrayDeque;
import java.util.Scanner;

class Container {
    String id;
    String description;
    int weight;

    Container(String id, String description, int weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public String toString() {
        return id + " | " + description + " | " + weight + "kg";
    }
}

class Ship {
    String name;
    String captain;

    Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    public String toString() {
        return name + " | " + captain;
    }
}

public class PortContainerManagement {
    public static void main(String[] args) {
        ArrayDeque<Container> containerStack = new ArrayDeque<>();
        ArrayDeque<Ship> shipQueue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship (pop container + poll ship)");
            System.out.println("[0] Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 0) {
                System.out.println("Exiting program.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter container id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter weight (kg): ");
                    int weight = sc.nextInt();
                    sc.nextLine();
                    Container c = new Container(id, desc, weight);
                    containerStack.push(c);
                    System.out.println("Stored: " + c);
                    break;

                case 2:
                    if (containerStack.isEmpty()) {
                        System.out.println("No containers in port.");
                    } else {
                        System.out.println("TOP →");
                        for (Container cont : containerStack) {
                            System.out.println(cont);
                        }
                        System.out.println("← BOTTOM");
                    }
                    break;

                case 3:
                    System.out.print("Enter ship name: ");
                    String shipName = sc.nextLine();
                    System.out.print("Enter captain name: ");
                    String captain = sc.nextLine();
                    Ship s = new Ship(shipName, "Capt. " + captain);
                    shipQueue.offer(s);
                    System.out.println("Registered: " + s);
                    break;

                case 4:
                    if (shipQueue.isEmpty()) {
                        System.out.println("No ships waiting.");
                    } else {
                        System.out.println("FRONT →");
                        for (Ship ship : shipQueue) {
                            System.out.println(ship);
                        }
                        System.out.println("← REAR");
                    }
                    break;

                case 5:
                    if (containerStack.isEmpty()) {
                        System.out.println("No containers to load.");
                    } else if (shipQueue.isEmpty()) {
                        System.out.println("No ships waiting.");
                    } else {
                        Container loadCont = containerStack.pop();
                        Ship loadShip = shipQueue.poll();
                        System.out.println("Loaded: " + loadCont + " → " + loadShip + "\n");
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships waiting: " + shipQueue.size());
                    }
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
