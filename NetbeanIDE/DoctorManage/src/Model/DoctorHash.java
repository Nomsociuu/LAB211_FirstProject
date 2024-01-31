package Model;

import java.util.HashMap;
import java.util.Map;

public class DoctorHash {
    private Map<String, Doctor> doctorMap;

    public DoctorHash() {
        this.doctorMap = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null || doctor.getCode() == null || doctor.getName() == null || doctor.getSpecialization() == null) {
            throw new Exception("Data does not exist");
        }

        if (doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");
        }

        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null || doctor.getCode() == null || doctor.getName() == null || doctor.getSpecialization() == null) {
            throw new Exception("Data does not exist");
        }

        if (!doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }

        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean deleteDoctor(Doctor doctor) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (doctor == null || doctor.getCode() == null || doctor.getName() == null || doctor.getSpecialization() == null) {
            throw new Exception("Data does not exist");
        }

        if (!doctorMap.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }

        doctorMap.remove(doctor.getCode());
        return true;
    }

    public Map<String, Doctor> searchDoctor(String input) throws Exception {
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        Map<String, Doctor> searchResult = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            if (containsIgnoreCase(doctor, input)) {
                searchResult.put(doctor.getCode(), doctor);
            }
        }

        return searchResult;
    }

    private boolean containsIgnoreCase(Doctor doctor, String input) {
        return doctor.getCode().toLowerCase().contains(input.toLowerCase()) ||
               doctor.getName().toLowerCase().contains(input.toLowerCase()) ||
               doctor.getSpecialization().toLowerCase().contains(input.toLowerCase()) ||
               String.valueOf(doctor.getAvailability()).toLowerCase().contains(input.toLowerCase());
    }

    public Map<String, Doctor> getDoctorMap() {
        return doctorMap;
    }
}
