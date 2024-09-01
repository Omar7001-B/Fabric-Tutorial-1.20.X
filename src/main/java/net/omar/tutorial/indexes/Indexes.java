package net.omar.tutorial.indexes;

import net.omar.tutorial.classes.Trade;

import java.util.List;

public class Indexes {

    // General Inventory Indexes
    public static class Inventory {

        // Offhand slot index
        public static final int OFFHAND_SLOT = 45;

        // Armor indexes
        public static final List<Integer> ARMOR = List.of(5, 6, 7, 8);

        // Main inventory indexes
        public static final List<Integer> MAIN = List.of(
                9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35
        );

        // Hotbar indexes
        public static final List<Integer> HOTBAR = List.of(
                36, 37, 38, 39, 40, 41, 42, 43, 44
        );

        // Total inventory indexes
        public static final List<Integer> TOTAL_INVENTORY = List.of(
                9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44
        );
    }

    // PV Inventory Indexes
    public static class PV {

        // PV slots (0-53)
        public static final List<Integer> PV = List.of(
                0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44,
                45, 46, 47, 48, 49, 50, 51, 52, 53
        );

        // Main inventory indexes (54-80)
        public static final List<Integer> MAIN_INVENTORY = List.of(
                54, 55, 56, 57, 58, 59, 60, 61, 62,
                63, 64, 65, 66, 67, 68, 69, 70, 71,
                72, 73, 74, 75, 76, 77, 78, 79, 80
        );

        // Hotbar indexes (81-89)
        public static final List<Integer> HOTBAR = List.of(
                81, 82, 83, 84, 85, 86, 87, 88, 89
        );

        // Total inventory indexes
        public static final List<Integer> TOTAL_INVENTORY = List.of(
                54, 55, 56, 57, 58, 59, 60, 61, 62,
                63, 64, 65, 66, 67, 68, 69, 70, 71,
                72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89
        );
    }

    // Shulker Inventory Indexes
    public static class Shulker {

        // Shulker Box indexes (0-26)
        public static final List<Integer> SHULKER_BOX = List.of(
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26
        );

        // Main inventory indexes (27-53)
        public static final List<Integer> MAIN_INVENTORY = List.of(
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53
        );

        // Hotbar indexes (54-62)
        public static final List<Integer> HOTBAR = List.of(
                54, 55, 56, 57, 58, 59, 60, 61, 62
        );

        // Total inventory indexes
        public static final List<Integer> TOTAL_INVENTORY = List.of(
                27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44,
                45, 46, 47, 48, 49, 50, 51, 52, 53,
                54, 55, 56, 57, 58, 59, 60, 61, 62
        );
    }

    public static class Trade {
        public static final int FIRST_ITEM_SLOT = 0;
        public static final int SECOND_ITEM_SLOT = 1;
        public static final int RESULT_SLOT = 2;

        // Main inventory slots from 3 to 29
        public static final List<Integer> MAIN_INVENTORY = List.of(
                3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29
        );

        // Hotbar slots from 30 to 38
        public static final List<Integer> HOTBAR = List.of(
                30, 31, 32, 33, 34, 35, 36, 37, 38
        );

        // Total inventory slots from 3 to 38
        public static final List<Integer> TOTAL_INVENTORY = List.of(
                3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35, 36, 37, 38
        );

        public static final List<Integer> TOTAL_INVENTORY_WITHOUT_RESULT_SLOT = List.of(
                0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35, 36, 37, 38
        );
    }
}
