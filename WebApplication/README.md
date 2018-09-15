Instructions:

- You can upload those 3 files directly on your "Static website hosting" S3 bucket in the root directory to make it work
- This is an example of a WebApp calling an API-Gateway (Ajax-call) and getting a one-parameter json (key=result).
- You can adapt it with any URL of an API (var apiGatewayURL).
- You can extend the html with more divs and can then set it in the callback ".done" function in script.js

- Add this Bucket Policy (in Permission in your S3 Bucket) in order to make it accessible for all

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadGetObject",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::de.opitz.expert.camp/*"
    }
  ]
}
```
