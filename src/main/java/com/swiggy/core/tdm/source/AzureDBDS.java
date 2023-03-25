package com.swiggy.core.tdm.source;

import com.swiggy.core.constants.Messages;
import com.swiggy.core.interfaces.TestDataRequest;
import com.swiggy.core.interfaces.TestDataResponse;
import com.swiggy.core.interfaces.TestDataSource;

public class AzureDBDS implements TestDataSource {
    @Override
    public TestDataResponse fetchTestData(TestDataRequest testDataRequest) {
        throw new UnsupportedOperationException(Messages.MSG_OPERATION_NOT_SUPPORTED);
    }
}
