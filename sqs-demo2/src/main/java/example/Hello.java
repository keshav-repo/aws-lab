package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;

public class Hello implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        // Log details natively to AWS CloudWatch Logs
        context.getLogger().log("Input event received: " + input);

        // Safely extract data from the incoming map
        String name = input.getOrDefault("name", "World");

        return "Hello, " + name + " from your Java Lambda!";
    }
}
