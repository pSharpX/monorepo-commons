package com.onebank.taskmaster.controlplane.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum AppIdentifier {
    CONTROL_PLANE_1( "Control Plane 1", "control-plane-1"),
    CONTROL_PLANE_2("Control Plane 2","control-plane-2");

    private final String name;
    private final String code;

    public static AppIdentifier getByCode(@NonNull String code) {
        return Stream.of(values())
                .filter(item -> item.getCode().equals(code)).findAny().orElse(null);
    }
}
