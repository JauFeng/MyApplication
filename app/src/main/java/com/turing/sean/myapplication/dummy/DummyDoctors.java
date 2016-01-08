package com.turing.sean.myapplication.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyDoctors {

    /**
     * An array of sample (dummy) doctors.
     */
    public static final List<DummyDoctor> DOCTORS = new ArrayList<>();

    /**
     * A map of sample (dummy) doctors, by ID.
     */
    public static final Map<String, DummyDoctor> DOCTOR_MAP = new HashMap<>();

    private static final int COUNT = 15;

    static {
        // Add some sample doctors.
        for (int i = 1; i <= COUNT; i++) {
            addDoctor(createDummyDoctor(i));
        }
    }

    private static void addDoctor(DummyDoctor doctor) {
        DOCTORS.add(doctor);
        DOCTOR_MAP.put(doctor.id, doctor);
    }

    private static DummyDoctor createDummyDoctor(int position) {
        String id = String.valueOf(position);
        return new DummyDoctor(id,"牟小芬", "主治医师", "中国人民解放军301医院", "产前各种突发状况、产检");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy doctor representing a piece of doctors.
     */
    public static class DummyDoctor {
        public final String id;
        public final String doctorName;
        public final String doctorTitle;
        public final String doctorHospital;
        public final String doctorFeature;

        public DummyDoctor(String id, String doctorName, String doctorTitle, String doctorHospital, String doctorFeature) {
            this.id = id;
            this.doctorName = doctorName;
            this.doctorTitle = doctorTitle;
            this.doctorHospital = doctorHospital;
            this.doctorFeature = doctorFeature;
        }

        @Override
        public String toString() {
            return "DummyDoctor{" +
                    "id='" + id + '\'' +
                    ", doctorName='" + doctorName + '\'' +
                    ", doctorTitle='" + doctorTitle + '\'' +
                    ", doctorHospital='" + doctorHospital + '\'' +
                    ", doctorFeature='" + doctorFeature + '\'' +
                    '}';
        }
    }
}
