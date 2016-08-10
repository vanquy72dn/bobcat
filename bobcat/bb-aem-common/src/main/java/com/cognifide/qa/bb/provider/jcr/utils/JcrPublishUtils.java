/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.provider.jcr.utils;

import javax.inject.Named;

import com.cognifide.qa.bb.constants.AemConfigFilenames;
import com.cognifide.qa.bb.provider.jcr.properties.InstanceProperties;
import com.google.inject.Inject;

/**
 * JcrUtilsProvider implementation for Publish
 */
public class JcrPublishUtils extends JcrUtils {

  @Inject
  @Named(AemConfigFilenames.PUBLISH_PROPERTIES)
  private InstanceProperties publishProperties;

  /**
   * @return instance of properties for publish environment
   */
  @Override
  public InstanceProperties getProperties() {
    return publishProperties;
  }
}
