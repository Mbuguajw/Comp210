package hospital;

public class Main {

    public static void main(String[] args) {
        /*
        Part 1
         */
        SimpleEmergencyRoom fullHouse = new SimpleEmergencyRoom();
        fillER(fullHouse);
        double startTime = System.nanoTime();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        fullHouse.dequeue();
        double endTime = System.nanoTime();
        double avgTime = (endTime - startTime) / 10.0;
        System.out.println(avgTime);
       /*
        Part 2
         */
        MinBinHeapER fullerHouse = new MinBinHeapER();
        fillER(fullerHouse);
        double start = System.nanoTime();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        fullerHouse.dequeue();
        double end = System.nanoTime();
        double avg = (end - start) / 10.0;
        System.out.println(avg);
        /*
        Part 3
         */
        MinBinHeapER transfer = new MinBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }

    }

    public static void fillER(MinBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }



}



