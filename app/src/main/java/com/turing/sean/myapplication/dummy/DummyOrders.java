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
public class DummyOrders {

    /**
     * An array of sample (dummy) orders.
     */
    public static final List<DummyOrder> ORDERS = new ArrayList<>();

    /**
     * A map of sample (dummy) orders, by ID.
     */
    public static final Map<String, DummyOrder> ORDER_MAP = new HashMap<>();

    private static final int COUNT = 15;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addOrder(createDummyOrder(i));
        }
    }

    private static void addOrder(DummyOrder order) {
        ORDERS.add(order);
        ORDER_MAP.put(order.id, order);
    }

    private static DummyOrder createDummyOrder(int position) {
        String id = String.valueOf(position);
        return new DummyOrder(id, "专家预约", "牟小芬", "妇产科",
                "中国人民解放军301医院", "北京市朝阳区林萃路1号院国奥村花园酒店2008室",
                "1月16日 周三 上午", "2000", "details");
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
     * A dummy order representing a piece of orders.
     */
    public static class DummyOrder {
        public final String id;
        public final String orderType;
        public final String doctorName;
        public final String section;
        public final String hospital;
        public final String address;
        public final String orderDate;
        public final String cost;
        public final String details;

        public DummyOrder(String id, String orderType, String doctorName,
                          String section, String hospital, String address,
                          String orderDate, String cost, String details) {
            this.id = id;
            this.orderType = orderType;
            this.doctorName = doctorName;
            this.section = section;
            this.hospital = hospital;
            this.address = address;
            this.orderDate = orderDate;
            this.cost = cost;
            this.details = details;
        }

        @Override
        public String toString() {
            return "DummyOrder{" +
                    "id='" + id + '\'' +
                    ", orderType='" + orderType + '\'' +
                    ", doctorName='" + doctorName + '\'' +
                    ", section='" + section + '\'' +
                    ", hospital='" + hospital + '\'' +
                    ", address='" + address + '\'' +
                    ", orderDate='" + orderDate + '\'' +
                    ", cost='" + cost + '\'' +
                    ", details='" + details + '\'' +
                    '}';
        }
    }
}
