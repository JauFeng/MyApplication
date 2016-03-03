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
object DummyOrders {

    /**
     * An array of sample (dummy) orders.
     */
    val ORDERS: MutableList<DummyOrder> = ArrayList()

    /**
     * A map of sample (dummy) orders, by ID.
     */
    val ORDER_MAP: MutableMap<String, DummyOrder> = HashMap()

    private val COUNT = 15

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addOrder(createDummyOrder(i))
        }
    }

    private fun addOrder(order: DummyOrder) {
        ORDERS.add(order)
        ORDER_MAP.put(order.id, order)
    }

    private fun createDummyOrder(position: Int): DummyOrder {
        val id = position.toString()
        return DummyOrder(id, "专家预约", "牟小芬", "妇产科主治医师",
                "中国人民解放军301医院", "北京市朝阳区林萃路1号院国奥村花园酒店2008室",
                "1月16日 周三 上午", "2000", "details")
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
     * A dummy order representing a piece of orders.
     */
    class DummyOrder(val id: String, val orderType: String, val doctorName: String,
                     val section: String, val hospital: String, val address: String,
                     val orderDate: String, val cost: String, val details: String) {

        override fun toString(): String {
            return "DummyOrder{id='$id\', orderType='$orderType\', doctorName='$doctorName\', section='$section\', hospital='$hospital\', address='$address\', orderDate='$orderDate\', cost='$cost\', details='$details\'}"
        }
    }
}
