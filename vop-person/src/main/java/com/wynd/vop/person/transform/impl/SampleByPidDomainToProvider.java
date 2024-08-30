package com.wynd.vop.person.transform.impl;

import com.wynd.vop.framework.transfer.transform.AbstractDomainToProvider;
import com.wynd.vop.person.api.model.v1.SampleInfo;
import com.wynd.vop.person.api.model.v1.SampleResponse;
import com.wynd.vop.person.model.SampleDomainResponse;

/**
 * Transforms a service Domain {@link SampleDomainResponse} into a REST Provider {@link SampleResponse} object.
 * <br>
 * This class is responsible for converting a {@link SampleDomainResponse} domain object into a
 * {@link SampleResponse} provider object that is used in REST API responses.
 * <p>
 * <b>Note:</b> Member objects inside the returned {@link SampleResponse} object may be {@code null}.
 * </p>
 * <p>
 * This transformation includes copying basic data such as the name and participant ID from the
 * {@link SampleDomainResponse} to the {@link SampleResponse}, as well as transferring any service messages
 * that might be present.
 * </p>
 */
public class SampleByPidDomainToProvider extends AbstractDomainToProvider<SampleDomainResponse, SampleResponse> {

  /**
   * Converts the provided {@link SampleDomainResponse} domain object into a {@link SampleResponse} provider object.
   * <p>
   * This method performs the following actions:
   * <ul>
   *   <li>Transfers the name and participant ID from the domain object's {@link SampleInfo} to the provider object's {@link SampleInfo}.</li>
   *   <li>Copies any service messages from the domain object to the provider object.</li>
   * </ul>
   * </p>
   *
   * @param domainObject The {@link SampleDomainResponse} object to be converted.
   *                     This can be {@code null}, in which case the returned {@link SampleResponse} will have no data.
   * @return A {@link SampleResponse} object that contains the converted data from the provided domain object.
   */
  @Override
  public SampleResponse convert(SampleDomainResponse domainObject) {
    SampleResponse providerObject = new SampleResponse();

    // add data
    SampleInfo providerData = new SampleInfo();
    if (domainObject != null && domainObject.getSampleInfo() != null) {
      providerData.setName(domainObject.getSampleInfo().getName());
      providerData.setParticipantId(domainObject.getSampleInfo().getParticipantId());
    }
    providerObject.setSampleInfo(providerData);

    // add messages
    if (domainObject != null && domainObject.getMessages() != null && !domainObject.getMessages().isEmpty()) {
      for (com.wynd.vop.framework.messages.ServiceMessage domainMsg : domainObject.getMessages()) {
        providerObject.addMessage(domainMsg.getSeverity(), domainMsg.getKey(), domainMsg.getText(),
            domainMsg.getHttpStatus());
      }
    }

    return providerObject;
  }
}
