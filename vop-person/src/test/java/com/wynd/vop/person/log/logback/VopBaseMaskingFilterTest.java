package com.wynd.vop.person.log.logback;

import com.wynd.vop.framework.log.logback.VopMaskingFilter;
import com.wynd.vop.framework.log.VopLoggerFactory;
import com.wynd.vop.framework.log.VopLogger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.event.Level;
import org.springframework.boot.test.system.OutputCaptureRule;

import static org.junit.Assert.assertTrue;

public class VopBaseMaskingFilterTest {

  @Rule
  public OutputCaptureRule capture = new OutputCaptureRule();

  class TestVopBaseMaskingFilter extends VopMaskingFilter {
    // test class
  }

  TestVopBaseMaskingFilter sharedBBMF;

  @Before
  public void setUp() {
    sharedBBMF = new TestVopBaseMaskingFilter();
  }

  @Test
  public final void testEvaluatePattern() {

    String msg = "Test Pattern 123-456 value";
    VopLogger logger = VopLoggerFactory.getLogger(VopMaskingFilter.class);
    logger.setLevel(Level.INFO);
    logger.info(msg);
    String log = capture.toString();
    assertTrue(log.contains("Test Pattern ****456 value"));
  }

  @Test
  public final void testEvaluateDate() {

    String msg = "Test Date Pattern 1234-56-78 value";
    VopLogger logger = VopLoggerFactory.getLogger(VopMaskingFilter.class);
    logger.setLevel(Level.INFO);
    logger.info(msg);
    String log = capture.toString();
    assertTrue(log.contains("Test Date Pattern ********78 value"));
  }
}
