package com.zensar.SamuraiZenAnalyticaIntegration.service;

import com.zensar.SamuraiZenAnalyticaIntegration.model.SamuraiRpaDto;

public interface SamuraiRpaService {

	SamuraiRpaDto saveRpaRequest(SamuraiRpaDto dto);

	SamuraiRpaDto mergeRpaRequest(SamuraiRpaDto rpaDto3);

}