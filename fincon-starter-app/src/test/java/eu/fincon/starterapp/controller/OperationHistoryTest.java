package eu.fincon.starterapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.fincon.starterapp.base.BaseTest;
import eu.fincon.starterapp.operationhistory.model.OperationHistory;
import eu.fincon.starterapp.operationhistory.service.OperationHistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationHistoryTest extends BaseTest {

  @Autowired OperationHistoryService operationHistoryService;

  @Test
  void myFirstTest() {
    // Given
    operationHistoryService.save(
        OperationHistory.builder().id(1L).operation("/foo").params("bar").build());

    // When
    OperationHistory operationHistory = operationHistoryService.findOne(1L).orElseThrow();

    // Then
    assertEquals("/foo", operationHistory.getOperation());
    assertEquals("bar", operationHistory.getParams());
  }
}
