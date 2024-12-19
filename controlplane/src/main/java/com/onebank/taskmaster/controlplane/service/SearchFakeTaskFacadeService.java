package com.onebank.taskmaster.controlplane.service;

import com.onebank.taskmaster.controlplane.config.ConditionalOnCacheDisabled;
import com.onebank.taskmaster.controlplane.model.SearchTaskParam;
import com.onebank.taskmaster.controlplane.model.SearchTaskResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnCacheDisabled
public class SearchFakeTaskFacadeService implements SearchTaskFacade {
    private final SearchTask searchTaskService;

    @Override
    public SearchTaskResponse search(@NonNull SearchTaskParam param) {
        return this.searchTaskService.search(param);
    }
}
