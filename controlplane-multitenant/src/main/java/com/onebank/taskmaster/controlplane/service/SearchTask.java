package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.model.SearchTaskParam;
import com.onebank.taskmaster.controlplane.model.SearchTaskResponse;
import lombok.NonNull;

public interface SearchTask {
	SearchTaskResponse search(@NonNull SearchTaskParam param);
}
