package com.wynd.vop.person;

import com.wynd.vop.person.model.SampleDomainResponse;
import com.wynd.vop.person.model.SampleDomainRequest;

/**
 * The contract interface for the domain (service) layer.
 */
public interface PersonService {
  /**
   * Search for the sample info by their Participant ID.
   *
   * @param sampleDomainRequest A SampleDomainRequest instance
   * @return A SampleDomainResponse instance
   */
  SampleDomainResponse sampleFindByParticipantId(SampleDomainRequest sampleDomainRequest);
}
