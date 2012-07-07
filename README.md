Android-REST-Client
===================

an Android REST Client utility, basicly this is a utility to make accessing web service a lot easier

code originally from: http://lukencode.com/2010/04/27/calling-web-services-in-android-using-httpclient/

Feature:
- Easy to use
- Support GZIP

TODO:
- Add https support


HOW to USE :
 RestClient client = new RestClient(LOGIN_URL);
 client.AddParam("accountType", "GOOGLE");
 client.AddParam("source", "tboda-widgalytics-0.1");
 client.AddParam("Email", _username);
 client.AddParam("Passwd", _password);
 client.AddParam("service", "analytics");
 client.AddHeader("GData-Version", "2");
  
 try {
      client.Execute(RequestMethod.POST);
 } catch (Exception e) {
      e.printStackTrace();
 }
  
 String response = client.getResponse();
