/*
 * Copyright 2023 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.idea.blaze.java.fastbuild;

import com.google.common.collect.ImmutableList;
import com.google.idea.blaze.base.model.BlazeVersionData;
import com.google.idea.blaze.base.model.primitives.Label;
import com.google.idea.blaze.base.model.primitives.TargetExpression;
import com.google.idea.blaze.base.settings.BuildSystemName;
import com.google.idea.blaze.base.util.BuildSystemExtensionPoint;
import com.intellij.openapi.extensions.ExtensionPointName;

abstract class FastBuildDeployJarStrategy implements BuildSystemExtensionPoint {
  private static final ExtensionPointName<FastBuildDeployJarStrategy> EP_NAME =
      ExtensionPointName.create("com.google.idea.blaze.FastBuildDeployJarStrategy");

  static FastBuildDeployJarStrategy getInstance(BuildSystemName buildSystemName) {
    return BuildSystemExtensionPoint.getInstance(EP_NAME, buildSystemName);
  }

  public abstract ImmutableList<? extends TargetExpression> getBuildTargets(
      Label label, BlazeVersionData versionData);

  public abstract ImmutableList<String> getBuildFlags(BlazeVersionData versionData);

  public abstract Label createDeployJarLabel(Label label, BlazeVersionData versionData);

  public abstract Label deployJarOwnerLabel(Label label, BlazeVersionData versionData);
}
