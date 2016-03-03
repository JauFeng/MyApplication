package myapplication.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyDoctors {

    /**
     * An array of sample (dummy) doctors.
     */
    val DOCTORS: MutableList<DummyDoctor> = ArrayList()

    /**
     * A map of sample (dummy) doctors, by ID.
     */
    val DOCTOR_MAP: MutableMap<String, DummyDoctor> = HashMap()

    private val COUNT = 15

    init {
        // Add some sample doctors.
        for (i in 1..COUNT) {
            addDoctor(createDummyDoctor(i))
        }
    }

    private fun addDoctor(doctor: DummyDoctor) {
        DOCTORS.add(doctor)
        DOCTOR_MAP.put(doctor.id, doctor)
    }

    private fun createDummyDoctor(position: Int): DummyDoctor {
        val id = position.toString()
        return DummyDoctor(id, "牟小芬", "主治医师", "中国人民解放军301医院", "产前各种突发状况、产检")
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy doctor representing a piece of doctors.
     */
    class DummyDoctor(val id: String, val doctorName: String, val doctorTitle: String, val doctorHospital: String, val doctorFeature: String) {

        override fun toString(): String {
            return "DummyDoctor{id='$id\', doctorName='$doctorName\', doctorTitle='$doctorTitle\', doctorHospital='$doctorHospital\', doctorFeature='$doctorFeature\'}"
        }
    }
}
