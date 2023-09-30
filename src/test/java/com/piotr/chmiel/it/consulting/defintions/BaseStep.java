package com.piotr.chmiel.it.consulting.defintions;

import com.piotr.chmiel.it.consulting.testContext.TestContext;
import lombok.Getter;

@Getter
public class BaseStep {
    private TestContext testContext;

    public BaseStep(TestContext testContext) {
        this.testContext = testContext;
    }
}
