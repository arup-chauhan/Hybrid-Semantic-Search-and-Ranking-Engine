package com.hybrid.orchestration;

import com.hybrid.orchestration.service.OrchestrationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class OrchestrationServiceTest {
    @Test
    void testExecuteWorkflow() {
        OrchestrationService service = new OrchestrationService();
        assertDoesNotThrow(service::executeWorkflow);
    }
}
