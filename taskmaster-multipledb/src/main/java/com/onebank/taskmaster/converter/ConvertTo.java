package com.onebank.taskmaster.converter;

import lombok.NonNull;

public interface ConvertTo<I,O> {
    O convert(@NonNull I input);
}
