/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2018 Cognifide Ltd.
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
package com.cognifide.qa.bb.junit5.properties;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.create;

import java.util.Properties;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SystemPropertyExtension implements BeforeEachCallback, AfterEachCallback {

  private static final ExtensionContext.Namespace NAMESPACE = create("com.cognifide.qa.bb");
  private static final String INITIAL_PROPERTIES = "initialProperties";

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    Properties properties = context.getStore(NAMESPACE).get(INITIAL_PROPERTIES, Properties.class);
    System.setProperties(properties);
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    Properties rawProps = System.getProperties();
    context.getStore(NAMESPACE).put(INITIAL_PROPERTIES, rawProps);
    System.setProperties(new Properties(rawProps));
  }
}
