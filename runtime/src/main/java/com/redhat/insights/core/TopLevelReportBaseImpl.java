/* Copyright (C) Red Hat 2022-2023 */
package com.redhat.insights.core;

import com.redhat.insights.AbstractTopLevelReportBase;
import com.redhat.insights.InsightsSubreport;
import com.redhat.insights.logging.InsightsLogger;
import java.util.*;

/**
 * Base class that collects basic information and delegates to the subreport for product-specific
 * details.
 *
 * <p>Products that want to provide Insights reports will subclass this class and also provide a
 * subreport class and a serializer.
 */
public class TopLevelReportBaseImpl extends AbstractTopLevelReportBase {

  public TopLevelReportBaseImpl(InsightsLogger logger, Map<String, InsightsSubreport> subReports) {
    super(logger, subReports);
  }

  @Override
  protected long getProcessPID() {
    return ProcessHandle.current().pid();
  }

  @Override
  protected Package[] getPackages() {
    return ClassLoader.getSystemClassLoader().getDefinedPackages();
  }
}
