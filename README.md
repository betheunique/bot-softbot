# SoftBot

SlackBot based on Spring. With functionality include Sending Email, SMS, Talking, Inspiring.
```
- SoftBot talk with SendGrid for Email.
- SoftBot talk with InfoBip for SMS.
- SoftBot talk with DailyQuote for Inspiring Quote.
- SoftBot talk with few ThirdParty open news provider.
- SoftBot maintaine its own Knowledge Base (Initially very less, will improve over the time).
```

### Configuration
```
application.properties
Add slack token
token=

For Email Functionality with SendGrid
Add Authorization key
sendgrid.authorization.key=

For SMS Functionality with InfoBip
Add Infobip key
infobip.key=
```

### Running
```
mvn clean package
```

### Deployment
```
Deploy packaged war to your specific container (I used tomcat). I will be updating it to embedded tomcat.
```

##### Any Suggestion please reach out to me at abhisheksavitarai at gmail dot com


