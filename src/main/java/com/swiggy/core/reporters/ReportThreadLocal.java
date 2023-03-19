package com.swiggy.core.reporters;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportThreadLocal {
    private final ThreadLocal<Report> reportThreadLocal = new InheritableThreadLocal<>();

}
