package com.wynd.vop.person.model.validators;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.wynd.vop.framework.log.VopLogger;
import com.wynd.vop.framework.log.VopLoggerFactory;
import com.wynd.vop.framework.messages.MessageSeverity;
import com.wynd.vop.framework.messages.ServiceMessage;
import com.wynd.vop.framework.validation.AbstractStandardValidator;
import com.wynd.vop.person.exception.PersonServiceException;
import com.wynd.vop.person.messages.PersonMessageKeys;
import com.wynd.vop.person.model.SampleDomainRequest;
import com.wynd.vop.person.model.SampleDomainResponse;

/**
 * Validates the PID input on the {@link SampleDomainResponse}.
 *
 * @see AbstractStandardValidator
 */
public class SampleDomainResponseValidator extends AbstractStandardValidator<SampleDomainResponse> {

  /**
   * Class logger
   */
  private static final VopLogger LOGGER = VopLoggerFactory.getLogger(SampleDomainResponseValidator.class);

  /**
   * The method that caused this validator to be invoked
   */
  private Method callingMethod;

  /*
   * (non-Javadoc)
   *
   * @see com.wynd.vop.framework.validation.AbstractStandardValidator#validate(java.lang.Object, java.util.List)
   */
  @Override
  public void validate(SampleDomainResponse toValidate, List<ServiceMessage> messages) {
    Object supplemental = getSupplemental(SampleDomainRequest.class);
    SampleDomainRequest request =
        supplemental == null ? new SampleDomainRequest() : (SampleDomainRequest) supplemental;

    // if response has errors, fatals or warnings skip validations
    if (toValidate != null && (toValidate.hasErrors()
        || toValidate.hasFatals()
        || toValidate.hasWarnings())) {
      return;
    }
    // check if empty response, or errors / fatals
    if ((toValidate == null) || (toValidate.getSampleInfo() == null)) {
      PersonMessageKeys key = PersonMessageKeys.VOP_SAMPLE_REQUEST_NOTNULL;
      LOGGER.info(key.getKey() + " " + key.getMessage());
      throw new PersonServiceException(key, MessageSeverity.FATAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  /*
   * (non-Javadoc)
   *
   * @see com.wynd.vop.framework.validation.AbstractStandardValidator#setCallingMethod(java.lang.reflect.Method)
   */
  @Override
  public void setCallingMethod(Method callingMethod) {
    this.callingMethod = callingMethod;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.wynd.vop.framework.validation.AbstractStandardValidator#getCallingMethod()
   */
  @Override
  public Method getCallingMethod() {
    return this.callingMethod;
  }
}
