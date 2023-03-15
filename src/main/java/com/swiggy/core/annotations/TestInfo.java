package com.swiggy.core.annotations;


import com.swiggy.core.model.TestPriority;
import com.swiggy.core.model.TestcaseInventory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * This annotation captures the test case information associated with every test.
 * <p>
 * This information will be used during execution to publish reports.
 *
 * @author jkandul
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {

    /**
     * Test case inventory Type.
     *
     * @return
     */
    TestcaseInventory testcaseInvType() default TestcaseInventory.JIRA;

    /**
     * Test case location in this inventory.
     *
     * @return
     */
    String testLocation() default "Swiggy";

    /**
     * Unique identifier for this test.
     *
     * @return
     */
    String testId();

    /**
     * Test case Area in this inventory.
     *
     * @return
     */
    String testArea();

    /**
     * Test case Owner, person who is automating the test case
     *
     * @return
     */
    String testOwner();

    TestPriority priority();

    /**
     * Test Suite Id in Test Rail, optional parameter
     *
     * @return
     */

    String testSuiteId() default "";
}

