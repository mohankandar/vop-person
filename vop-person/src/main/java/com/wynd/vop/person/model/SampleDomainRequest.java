package com.wynd.vop.person.model;

import com.wynd.vop.framework.service.DomainRequest;

/**
 * This domain model represents a request for SampleInfoDomain by participant ID.
 * <p>This request is used by the domain service implementation to derive the appropriate response.</p>
 */
public class SampleDomainRequest extends DomainRequest {
  public static final String MODEL_NAME = SampleDomainRequest.class.getSimpleName();

  /**
   * version id.
   */
  private static final long serialVersionUID = 1593666859950183199L;

  /**
   * A Long representing a participant ID.
   */
  private Long participantId;

  /**
   * Gets the participant ID.
   *
   * @return the participant ID
   */
  public final Long getParticipantId() {
    return this.participantId;
  }

  /**
   * Sets the participant ID.
   *
   * @param participantId the participant ID
   */
  public final void setParticipantId(final Long participantId) {
    this.participantId = participantId;
  }
}
