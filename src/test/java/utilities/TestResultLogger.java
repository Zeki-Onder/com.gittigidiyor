package utilities;

import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.util.Optional;


    public class TestResultLogger implements TestWatcher {

        Log4j log = new Log4j();

        @Override
        public void testSuccessful(ExtensionContext context) {
            String testName = context.getDisplayName();
            log.info(testName + " PASSED");
        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            String testName = context.getDisplayName();
            String testFailCause = cause.getMessage() ;
            log.error(testName + " FAILED with cause : " + testFailCause);
        }

        @Override
        public void testDisabled(ExtensionContext context, Optional<String> reason) {

        }

        @Override
        public void testAborted(ExtensionContext context, Throwable cause) {

        }
    }