package hospital;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO: dequeue
    public Patient dequeue() {
        if (size() == 0) {
            throw new UnsupportedOperationException();
        }
        int idx = find_min_idx();
        return this.patients.remove(idx);
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

    private int find_min_idx() {
        if (size() == 0) {
            throw new UnsupportedOperationException();
        }
        Patient min = patients.get(0);
        int min_idx = 0;

        for (int i = 1; i < patients.size(); i++) {
            if (patients.get(i).getPriority().compareTo(min.getPriority()) < 0) {
                min = patients.get(i);
                min_idx = i;
            }
        }

        return min_idx;
    }
}

