package uk.co.twoitesting.utilities;

import java.util.HashMap;
import java.util.Map;

public class SharedDictionary {

    private final Map<String,Object> sharedMap = new HashMap<>();

    public void addValue(String key, Object value) {
        sharedMap.put(key,value);
    }

    public Object getValue(String key) {
        return sharedMap.get(key);
    }
}
