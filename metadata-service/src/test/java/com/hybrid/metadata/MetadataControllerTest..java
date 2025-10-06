package com.hybrid.metadata;

import com.hybrid.metadata.controller.MetadataController;
import com.hybrid.metadata.model.MetadataRecord;
import com.hybrid.metadata.service.MetadataService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

class MetadataControllerTest {
    @Test
    void testSaveMetadata() {
        MetadataService mockService = Mockito.mock(MetadataService.class);
        MetadataController controller = new MetadataController(mockService);
        MetadataRecord record = new MetadataRecord();
        record.setDocumentId("doc123");
        Mockito.when(mockService.save(record)).thenReturn(record);
        assertThat(controller.save(record).getDocumentId()).isEqualTo("doc123");
    }
}
