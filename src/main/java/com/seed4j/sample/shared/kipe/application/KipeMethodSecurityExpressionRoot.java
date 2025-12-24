package com.seed4j.sample.shared.kipe.application;

import com.seed4j.sample.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import java.util.function.Supplier;
import org.aopalliance.intercept.MethodInvocation;
import org.jspecify.annotations.Nullable;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

@ExcludeFromGeneratedCodeCoverage(reason = "Spring glue bean")
class KipeMethodSecurityExpressionRoot extends SecurityExpressionRoot<MethodInvocation> implements MethodSecurityExpressionOperations {

  private final AccessEvaluator evaluator;

  private Object filterObject;
  private Object returnObject;
  private final Object target;

  public KipeMethodSecurityExpressionRoot(
    Supplier<? extends @Nullable Authentication> authentication,
    MethodInvocation methodInvocation,
    AccessEvaluator evaluator
  ) {
    super(authentication, methodInvocation);
    this.evaluator = evaluator;
    this.target = methodInvocation.getThis();
  }

  @Override
  public void setFilterObject(Object filterObject) {
    this.filterObject = filterObject;
  }

  @Override
  public Object getFilterObject() {
    return filterObject;
  }

  @Override
  public void setReturnObject(Object returnObject) {
    this.returnObject = returnObject;
  }

  @Override
  public Object getReturnObject() {
    return returnObject;
  }

  @Override
  public Object getThis() {
    return target;
  }

  public boolean can(String action, Object item) {
    return evaluator.can(getAuthentication(), action, item);
  }
}
