package io.camunda.example;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.error.ConnectorException;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.camunda.connector.generator.annotation.ElementTemplate;
import io.camunda.example.dto.MyConnectorRequest;
import io.camunda.example.dto.MyConnectorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OutboundConnector(name = "MYCONNECTOR", inputVariables = {}, type = "add-employee")
@ElementTemplate(id = "io.camunda.connector.Template.v1", name = "Template connector", version = 1, description = "Describe this connector", icon = "icon.svg", documentationRef = "https://docs.camunda.io/docs/components/connectors/out-of-the-box-connectors/available-connectors-overview/", propertyGroups = {
    @ElementTemplate.PropertyGroup(id = "authentication", label = "Authentication"),
    @ElementTemplate.PropertyGroup(id = "compose", label = "Compose")
}, inputDataClass = MyConnectorRequest.class)
public class EmployeeConnector implements OutboundConnectorFunction {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeConnector.class);

  @Override
  public Object execute(OutboundConnectorContext context) {
    final var connectorRequest = context.bindVariables(MyConnectorRequest.class);
    return executeConnector(connectorRequest);
  }

  private MyConnectorResult executeConnector(final MyConnectorRequest connectorRequest) {
    // TODO: implement connector logic
    LOGGER.info("Executing my connector with request {}", connectorRequest);

    return new MyConnectorResult("Employee assigned to a project! :-D");
  }
}
