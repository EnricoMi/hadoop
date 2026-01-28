package co.uk.gresearch.hadoop.fs.s3a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.core.interceptor.Context;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;
import software.amazon.awssdk.http.SdkHttpRequest;

public class DeleteInterceptor implements ExecutionInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(DeleteInterceptor.class);

    static {
        LOG.info("Loaded DeleteInterceptor");
    }

    public SdkHttpRequest modifyHttpRequest(Context.ModifyHttpRequest context, ExecutionAttributes executionAttributes) {
        LOG.info("modifyHttpRequest");
        SdkHttpRequest httpRequest = context.httpRequest();
        return httpRequest.toBuilder().putHeader("x-amz-delete-contents", "true").build();
    }
}
