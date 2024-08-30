package com.wynd.vop.person;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * The Class ApplicationConfig serves 2 purposes:
 * <ol>
 * <li>It provides a bean that classes can use to access our properties.</li>
 * <li>It allows the actuator and the /configprops endpoint to surface all bound/bindable properties as documentation.</li>
 * </ol>
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "vop-person")
@RefreshScope // refresh properties after app running
public class PersonProperties {

  @NotNull
  private String env;

  @NotNull
  private String propSource;

  @NotNull
  private String sampleProperty;

  @NotNull
  private String password;

  // UIEnablement
  // The usage of the word orIgIn in all lower case is problematic in the gen.sh script.
  // After generation, the scripts will replace with all lower case version or camel case version and uncomment as necessary.
  @NotNull
  private String[] orIgIns;

  /**
   * Gets the environment.
   *
   * @return the environment.
   */
  public String getEnv() {
    return env;
  }

  /**
   * Sets the environment.
   *
   * @param env the environment to set.
   */
  public void setEnv(String env) {
    this.env = env;
  }

  /**
   * Gets the property source.
   *
   * @return the property source.
   */
  public String getPropSource() {
    return propSource;
  }

  /**
   * Sets the property source.
   *
   * @param propSource the property source to set.
   */
  public void setPropSource(String propSource) {
    this.propSource = propSource;
  }

  /**
   * Gets the sample property.
   *
   * @return the sample property.
   */
  public String getSampleProperty() {
    return sampleProperty;
  }

  /**
   * Sets the sample property.
   *
   * @param sampleProperty the sample property to set.
   */
  public void setSampleProperty(String sampleProperty) {
    this.sampleProperty = sampleProperty;
  }

  /**
   * Gets the password.
   *
   * @return the password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   *
   * @param password the password to set.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets the origins (orIgIns).
   *
   * @return the origins.
   */
  public String[] getOrIgIns() {
    return orIgIns;
  }

  /**
   * Sets the origins (orIgIns).
   *
   * @param orIgIns the origins to set.
   */
  public void setOrIgIns(String[] orIgIns) {
    this.orIgIns = orIgIns;
  }
}
