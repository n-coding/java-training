package jp.co.training.command;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import jp.co.training.ItemCode;
import jp.co.training.Result;

public class CommandResult extends Result {

    private boolean exit = false;

    private Map<String, EnumSet<ItemCode>> itemCodes = new HashMap<>();

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public void addItemCode(String key, ItemCode itemCode) {
        if (itemCodes.get(key) == null) {
            itemCodes.put(key, EnumSet.noneOf(ItemCode.class));
        }
        itemCodes.get(key).add(itemCode);
    }

    public void addItemCodes(Map<String, EnumSet<ItemCode>> itemCodes) {
        for (Map.Entry<String, EnumSet<ItemCode>> e : itemCodes.entrySet()) {
            for (ItemCode code : e.getValue()) {
                addItemCode(e.getKey(), code);
            }
        }
    }

}
