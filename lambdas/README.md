This folder contains the code for a simple Lambda function that takes data from a csv file as input and parses the data into json format. The json is then logged in Cloudwatch.

Instructions:

- In your AWS console create a new nodejs Lambda.
- Copy-paste the code of parserHandler.js into the in-cloud code editor.
- Assert that your Lambda's Handler is configured correctly. For instance, if your Lambda's source code is in *index.js* and your main function is called *handler*, the Handler configured in your Lambda has to be *index.handler*.
- Create a test event and observe what happens in Cloudwatch. As a sample event you can use *sampleEvent.js*.