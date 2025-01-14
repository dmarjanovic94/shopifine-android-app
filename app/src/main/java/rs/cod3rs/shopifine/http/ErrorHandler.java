package rs.cod3rs.shopifine.http;

import android.util.Log;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.api.RestErrorHandler;
import org.springframework.core.NestedRuntimeException;

@EBean
public class ErrorHandler implements RestErrorHandler {

    @Override
    public void onRestClientExceptionThrown(final NestedRuntimeException e) {
        Log.e(getClass().getSimpleName(), e.getMessage());
        throw e;
    }

}
