package com.onebank.taskmaster.helpers;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@UtilityClass
public class StreamUtils {
    public HashMap<String, Object> streamConvert(Properties prop) {
        return prop.entrySet().stream().collect(
                Collectors.toMap(
                        e -> String.valueOf(e.getKey()),
                        Map.Entry::getValue,
                        (prev, next) -> next, HashMap::new
                ));
    }
}
