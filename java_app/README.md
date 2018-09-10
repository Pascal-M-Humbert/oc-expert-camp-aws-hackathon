Anleitung:

Setup:
- Java 8
- IntelliJ or your favorite IDE
- maven

Code to change depending on your case:
- BUCKET_NAME in ParserHandler.java for the path in S3
- Key in ParserHandler.java for the name of your file in the S3 Bucket
- CSV_SPLIT_CHARACTERE depending on the format of the file (csv -> comma)
- Transaction.java must be changed with the information of your file
  - small hint: delete the unused information with excel (Text in column + delete column) to go faster with this class
- createTransaction() in ParserHandler will fill-up your Object. The order of the columns matters

Packaging for deployment:
- mvn package
- upload the file "java-app-1.0-SNAPSHOT.jar" in target

