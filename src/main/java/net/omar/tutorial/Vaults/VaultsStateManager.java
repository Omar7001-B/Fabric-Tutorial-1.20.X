package net.omar.tutorial.Vaults;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import net.omar.tutorial.Managers.Naming;
import net.omar.tutorial.Managers.Debugging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VaultsStateManager {

    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static final Map<String, MyShulker> shulkerMap = new HashMap<>();
    private static final Map<String, MyPV> pvMap = new HashMap<>();
    private static final Map<String, MyInventory> inventoryMap = new HashMap<>();

    static void updateInventoryState(String name, String operation, List<Integer> indexes, InventoryEntry entry) {
        if (client.currentScreen == null) return;

        DefaultedList<Slot> slots = ((HandledScreen<?>) client.currentScreen).getScreenHandler().slots;
        entry.filledSlots = 0;
        entry.emptySlots = 0;
        entry.itemCounts.clear();
        entry.slotData.clear();

        indexes.forEach(index -> {
            Slot slot = slots.get(index);
            if (slot.hasStack()) {
                entry.filledSlots++;
                String itemName = slot.getStack().getItem().getName().getString();
                int count = slot.getStack().getCount();
                entry.itemCounts.merge(itemName, count, Integer::sum);
                entry.slotData.put(index, new InventoryEntry.ItemSlotInfo(itemName, count));
            } else {
                entry.emptySlots++;
            }
        });

        Debugging.Store("Updating " + name + " Inventory: " + operation + " After Update:" + entry.itemCounts);
    }

    public static int calculateTotalSlots(Map<String, Integer> items){
        int totalSlots = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            int count = entry.getValue();
            totalSlots += Naming.isStackedItem(itemName) ? (int)Math.ceil(count / 64.0) : 1;
        }
        return totalSlots;
    }

    public static MyShulker Shulker(String name) {
        return shulkerMap.computeIfAbsent(name, MyShulker::new);
    }

    public static MyPV PV(String name) {
        return pvMap.computeIfAbsent(name, MyPV::new);
    }

    public static MyInventory Inventory(String name) {
        return inventoryMap.computeIfAbsent(name, MyInventory::new);
    }
}

abstract class InventoryEntry {
    public final String name;
    public int filledSlots;
    public int emptySlots;
    public final Map<String, Integer> itemCounts = new HashMap<>();
    public final Map<Integer, ItemSlotInfo> slotData = new HashMap<>();

    protected InventoryEntry(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses
    public abstract void update(String name);

    public int getItemCountByName(String searchStr) {
        Debugging.Shop("ItemCounts: " + itemCounts);
        Debugging.Shop("Searching for: " + searchStr);
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            if (Naming.containsIgnoreCase(entry.getKey(), searchStr)) {
                Debugging.Shop("Found: " + entry.getKey() + ", Count: " + entry.getValue());
                return entry.getValue();
            }
        }
        return 0;
    }

    public void showData() {
        Debugging.Store("Data:");
        Debugging.Store("Filled Slots: " + filledSlots);
        Debugging.Store("Empty Slots: " + emptySlots);
        itemCounts.forEach((item, count) -> Debugging.Store("Item: " + item + ", Count: " + count));
        slotData.forEach((index, info) -> Debugging.Store("Slot: " + index + ", Item: " + info.itemName + ", Count: " + info.count));
        Debugging.Store(("-------------------"));
    }

    public static class ItemSlotInfo {
        String itemName;
        int count;

        ItemSlotInfo(String itemName, int count) {
            this.itemName = itemName;
            this.count = count;
        }
    }

    public void reset() {
        filledSlots = 0;
        emptySlots = 0;
        itemCounts.clear();
        slotData.clear();
    }
}

