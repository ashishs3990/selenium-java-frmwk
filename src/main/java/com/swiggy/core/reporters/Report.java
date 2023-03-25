package com.swiggy.core.reporters;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;

@Getter
@Setter
public class Report {

    private File screenshot;
    private boolean isSuccess;
    private String currentIndex;
    private String screenshotPath;
    private String logPath;
    private String testCaseDirPath;
    private File logFile;
    private boolean isTestFinished;
    private String browser;
    private String testCaseName;
    private String testCaseLocation;
    private String testCaseId;
    private String testCaseOwner;
    private String testCaseArea;
    private String testInvType;
    private Date testStartDate;
    private Date testEndDate;
    private int attemptNumber;
    private boolean resultsUpdatedToDB;
    private String exceptionName = null;
    private String exceptionErrorMessage = null;
    private String startupExceptionName = null;
    private String startupExceptionErrorMessage = null;
    private String browserMachine = "localhost"; // Remote machine where browser is opened.
    private String testCaseSuiteId;
}
