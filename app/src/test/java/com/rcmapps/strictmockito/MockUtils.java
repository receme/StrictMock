package com.rcmapps.strictmockito;

import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Created by receme on 2/19/17.
 */

public class MockUtils {

    public static <T> T strictMock(Class<T> cls) {
        return Mockito.mock(cls, new StrictMockHandler());
    }

    public static class StrictMockHandler implements Answer {
        public boolean strict = false;

        public Object answer(InvocationOnMock invocation) throws Throwable {
            if (strict) throw new NotStubbedException(invocation.getMethod().getName());
            return null;
        }
    }

    public static void verifyNoUnstubbedInteractions(Object mock) {
        StrictMockHandler handler = (StrictMockHandler) MockUtil.getMockHandler(mock).getMockSettings().getDefaultAnswer();
        handler.strict = true;

    }

    public static class NotStubbedException extends RuntimeException {
        public NotStubbedException(String message) {
            super(message);
        }
    }


}
