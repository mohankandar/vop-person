package com.wynd.vop.person.transform.impl;

import com.wynd.vop.framework.transfer.transform.AbstractProviderToDomain;
import com.wynd.vop.person.api.model.v1.SampleRequest;
import com.wynd.vop.person.model.SampleDomainRequest;

/**
 * Transforms a REST Provider {@link SampleRequest} into a service Domain {@link SampleDomainRequest} object.
 */
public class SampleByPidProviderToDomain extends AbstractProviderToDomain<SampleRequest, SampleDomainRequest> {

  /**
   * Transforms a REST Provider {@link SampleRequest} into a service Domain {@link SampleDomainRequest} object.
   * <p>{@inheritDoc}</p>
   */
  @Override
  public SampleDomainRequest convert(SampleRequest domainObject) {
    SampleDomainRequest providerObject = new SampleDomainRequest();
    if (domainObject != null) {
      providerObject.setParticipantId(domainObject.getParticipantID());
    }
    return providerObject;
  }

}
