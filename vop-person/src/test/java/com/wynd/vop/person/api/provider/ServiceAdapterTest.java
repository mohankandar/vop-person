package com.wynd.vop.person.api.provider;

import com.wynd.vop.framework.exception.VopValidationRuntimeException;
import com.wynd.vop.framework.log.VopLogger;
import com.wynd.vop.person.PersonService;
import com.wynd.vop.person.PersonTestUtils;
import com.wynd.vop.person.api.model.v1.SampleRequest;
import com.wynd.vop.person.api.model.v1.SampleResponse;
import com.wynd.vop.person.model.SampleDomainRequest;
import com.wynd.vop.person.model.SampleDomainResponse;
import com.wynd.vop.person.transform.impl.SampleByPidDomainToProvider;
import com.wynd.vop.person.transform.impl.SampleByPidProviderToDomain;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ServiceAdapterTest {

    ServiceAdapter instance;

    @Mock
    private VopLogger mockVopLogger;
    @Mock
    private SampleByPidProviderToDomain mockSampleByPidProviderToDomain;
    @Mock
    private SampleByPidDomainToProvider mockSampleByPidDomainToProvider;
    @Mock
    private PersonService mockPersonService;
    @Mock
    private SampleRequest mockSampleRequest;
    @Mock
    private SampleDomainRequest mockSampleDomainRequest;
    @Mock
    private SampleDomainResponse mockSampleDomainResponse;
    @Mock
    private SampleResponse mockSampleResponse;

    @Before
    public void setUp() {
        instance = new ServiceAdapter();

        MockitoAnnotations.initMocks(this);

        try {
            PersonTestUtils.setFinalStatic(ServiceAdapter.class.getDeclaredField("LOGGER"), mockVopLogger);
        } catch (Exception e) {
            // Ignore and attempt to test without
        }
        ReflectionTestUtils.setField(instance, "sampleByPidProvider2Domain", mockSampleByPidProviderToDomain);
        ReflectionTestUtils.setField(instance, "sampleByPidDomain2Provider", mockSampleByPidDomainToProvider);
        ReflectionTestUtils.setField(instance, "personService", mockPersonService);
    }

    @Test
    public void testPostConstruct_Success() {
        // Setup

        // Execute Test
        try {
            instance.postConstruct();
        } catch (VopValidationRuntimeException e) {
            // Verifications
            fail("A VopValidationRuntimeException should not have been thrown here.");
        }
    }

    @Test
    public void testPostConstruct_Failure1() {
        // Setup
        ReflectionTestUtils.setField(instance, "sampleByPidProvider2Domain", null);

        // Execute Test
        try {
            instance.postConstruct();
        } catch (VopValidationRuntimeException e) {
            return;
        }

        // Verifications
        fail("A VopValidationRuntimeException should have been thrown here.");
    }

    @Test
    public void testPostConstruct_Failure2() {
        // Setup
        ReflectionTestUtils.setField(instance, "sampleByPidDomain2Provider", null);

        // Execute Test
        try {
            instance.postConstruct();
        } catch (VopValidationRuntimeException e) {
            return;
        }

        // Verifications
        fail("A VopValidationRuntimeException should have been thrown here.");
    }

    @Test
    public void testPostConstruct_Failure3() {
        // Setup
        ReflectionTestUtils.setField(instance, "personService", null);

        // Execute Test
        try {
            instance.postConstruct();
        } catch (VopValidationRuntimeException e) {
            return;
        }

        // Verifications
        fail("A VopValidationRuntimeException should have been thrown here.");
    }

    @Test
    public void testSampleByPid() {
        // Setup
        when(mockSampleByPidProviderToDomain.convert(mockSampleRequest)).thenReturn(mockSampleDomainRequest);
        when(mockPersonService.sampleFindByParticipantID(mockSampleDomainRequest)).thenReturn(mockSampleDomainResponse);
        when(mockSampleByPidDomainToProvider.convert(mockSampleDomainResponse)).thenReturn(mockSampleResponse);

        // Execute Test
        SampleResponse response = instance.sampleByPid(mockSampleRequest);

        // Verifications
        assertNotNull(response);
        assertEquals(mockSampleResponse, response);
    }
}
