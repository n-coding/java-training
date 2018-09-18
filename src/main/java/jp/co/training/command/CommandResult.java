package jp.co.training.command;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.co.training.book.ItemCode;
import jp.co.training.common.Code;
import jp.co.training.common.Result;

public class CommandResult extends Result {

    private boolean exit = false;

    private final String commandName;

    private Map<String, Set<ItemCode>> itemCodes = new HashMap<>();

    private Set<Code> codes = new HashSet<>();

    private List<List<String>> records;

    public List<List<String>> getRecords() {
        return records;
    }

    public void addRecord(List<String> record) {
        this.records.add(record);
    }

    public CommandResult(String commandName) {
        this.commandName = commandName;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public String getCommandName() {
        return commandName;
    }

    public Map<String, Set<ItemCode>> getItemCodes() {
        return itemCodes;
    }

    public void addItemCode(String key, ItemCode itemCode) {
        if (itemCodes.get(key) == null) {
            itemCodes.put(key, new HashSet<>());
        }
        itemCodes.get(key).add(itemCode);
    }

    public void addItemCodes(Map<String, Set<ItemCode>> itemCodes) {
        for (Map.Entry<String, Set<ItemCode>> e : itemCodes.entrySet()) {
            for (ItemCode code : e.getValue()) {
                addItemCode(e.getKey(), code);
            }
        }
    }

    public Set<Code> getCodes() {
        return codes;
    }

    public void addCode(Code code) {
        codes.add(code);
    }

    public void addCodes(Set<Code> codes) {
        this.codes.addAll(codes);
    }

}
