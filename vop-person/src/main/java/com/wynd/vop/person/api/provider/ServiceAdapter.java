package com.wynd.vop.person.api.provider;

import com.wynd.vop.person.PersonService;
import com.wynd.vop.person.api.model.v1.SampleRequest;
import com.wynd.vop.person.api.model.v1.SampleResponse;
import com.wynd.vop.person.model.SampleDomainRequest;
import com.wynd.vop.person.model.SampleDomainResponse;
import com.wynd.vop.person.transform.impl.SampleByPidDomainToProvider;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wynd.vop.framework.log.VopLogger;
import com.wynd.vop.framework.log.VopLoggerFactory;
import com.wynd.vop.framework.validation.Defense;
import com.wynd.vop.person.transform.impl.SampleByPidProviderToDomain;

/**
 * ServiceAdapter acts as a bridge between the provider layer and the service layer.
 * It handles the transformation of data between the REST API models (provider layer)
 * and the internal service models (domain layer), ensuring that data can flow
 * between these layers seamlessly.
 */
@Component
public class ServiceAdapter {

	// Logger for debugging and logging information
	private static final VopLogger LOGGER = VopLoggerFactory.getLogger(ServiceAdapter.class);

	// Transformer for converting provider (REST) request to domain (service) request
	private SampleByPidProviderToDomain sampleByPidProvider2Domain = new SampleByPidProviderToDomain();

	// Transformer for converting domain (service) response to provider (REST) response
	private SampleByPidDomainToProvider sampleByPidDomain2Provider = new SampleByPidDomainToProvider();

	// Service interface for processing sampleByPid requests
	@Autowired
	@Qualifier("PERSON_SERVICE_IMPL")
	private PersonService personService;

	/**
	 * Ensures that essential components are properly initialized after dependency injection.
	 * This method is automatically invoked by the Spring container after the bean's
	 * construction and dependency injection are completed.
	 */
	@PostConstruct
	public void postConstruct() {
		Defense.notNull(personService); // Validate that the service is not null
		Defense.notNull(sampleByPidProvider2Domain); // Validate that the request transformer is not null
		Defense.notNull(sampleByPidDomain2Provider); // Validate that the response transformer is not null
	}

	/**
	 * Processes the sampleByPid request by transforming the provider request to a domain request,
	 * invoking the appropriate service layer method, and then transforming the domain response
	 * back to a provider response.
	 *
	 * @param sampleRequest The request object received from the REST API.
	 * @return SampleResponse The response object to be returned to the REST API.
	 */
	SampleResponse sampleByPid(final SampleRequest sampleRequest) {
		// Convert the incoming provider request to the domain request format
		LOGGER.debug("Transforming from provider sampleRequest to sampleDomainRequest");
		SampleDomainRequest domainRequest = sampleByPidProvider2Domain.convert(sampleRequest);

		// Invoke the service layer method using the transformed domain request
		LOGGER.debug("Calling personService.sampleFindByParticipantID");
		SampleDomainResponse domainResponse = personService.sampleFindByParticipantID(domainRequest);

		// Convert the domain response back to the provider response format
		LOGGER.debug("Transforming from domainResponse to providerResponse");
		return sampleByPidDomain2Provider.convert(domainResponse);
	}
}
