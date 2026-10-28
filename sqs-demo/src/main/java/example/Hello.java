package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Map;

public class Hello implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        context.getLogger().log("Input event received: " + input);

        Map<String, String> queryParams = input.getQueryStringParameters();
        String name = (queryParams != null) ? queryParams.getOrDefault("name", "World") : "World";

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody("Hello, " + name + " from your Java Lambda!");
    }
}
