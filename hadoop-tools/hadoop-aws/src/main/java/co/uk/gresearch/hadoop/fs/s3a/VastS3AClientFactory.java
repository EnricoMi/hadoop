package co.uk.gresearch.hadoop.fs.s3a;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.s3a.DefaultS3ClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;

import java.io.IOException;

// fs.s3a.client.factory.impl=co.uk.gresearch.hadoop.fs.s3a.VastS3AClientFactory
public class VastS3AClientFactory extends DefaultS3ClientFactory {
    private static final Logger LOG = LoggerFactory.getLogger(VastS3AClientFactory.class);

    static {
        LOG.info("Loaded VastS3AClientFactory");
    }

    @Override
    protected ClientOverrideConfiguration.Builder createClientOverrideConfiguration(S3ClientCreationParameters parameters, Configuration conf) throws IOException {
        LOG.info("createClientOverrideConfiguration");
        ClientOverrideConfiguration.Builder builder = super.createClientOverrideConfiguration(parameters, conf);
        builder.addExecutionInterceptor(new DeleteInterceptor());
        return builder;
    }
}
