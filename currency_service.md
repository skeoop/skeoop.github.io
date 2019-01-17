---
layout: page
title: Currency Converter
---
## Create a Currency Converter

You can define a kind of Unit in your Converter that converts currencies.  
Its not hard and the code is not that long.  You'll learn how to use a web service
and send HTTP requests using Java.

To do this, you need:

* Access to a web service to get currency exchange rates
* Java code to send a request and read the response. You can use URL and HttpURLConnection, which are part of the Java API.

## What's a Web Service?

A web service is a network service that uses the standard HTTP or HTTPS protocol of the web, but is designed to handle requests from a software program other than a a web browser.  
A web browser expects content in a format (HTML, images) that it can display to a human.
Web services exchange data in a format that's useful to other software.

The common data formats used by web services are:

* plain text, such as:
  ```
  USDTHB=31.17037
  ```
* JSON, a key-value textual representation of data, such as:
   ```
   {"success":true,
    "timestamp":1521858858,
    "source":"USD",
    "quotes":{"USDTHB":31.17037,"USDJPY":104.728996}
   }
   ```
* XML (eXtensible Markup Language) a more structured, tag-based markup language. For example:
   ```
   <convert type="live">
       <success>true</success>
       <timestamp>1521858858</timestamp>
       <source>USD</source>
       <quotes>
           <quote key="USDTHB">31.17037</quote>
           <quote key="USDJPY">104.728996</quote>
       </quotes>
    </convert>
    ```

To invoke a web service, you send an HTTP or HTTPS request to a URL.  For example, to get exchange rate for Thai Baht and Japan Yen, the HTTP request is (with xxxxxx instead of your actual API Key):
```
http://apilayer.net/api/live?access_key=xxxxxxx&currencies=THB,JPY
```

## Free Currency Exchange Rate Services

There are web services that provide currency exchange rates.

Here are a few free exchange rate services that are free: 

1. [CurrencyLayer.com](https://currencylayer.com) has a limited free currency conversion. The "source" currency is always USD in the free service, but you can convert to as many other currencies as you want.  Limit 1,000 queries per month.
2. [Bank of Thailand API](https://iapi.bot.or.th/Developer) has daily average exchange rate between Thai Baht (THB) and other currencies.

If you find another free service, please tell me.

## How to Use a Web Service

For "RESTful" web services, you send an ordinary HTTP request message with query parameters for the information you want (some services also use HTTP header fields or the request body).  The URL identifies the service that you want. 
Here are two examples:

* CurrencyLayer.com Live Exchange Rate service: `http://apilayer.net/api/live?query_params`
* Bank of Thailand Daily Exchange Rate service: `https://iapi.bot.or.th/Stat/Stat-ExchangeRate/DAILY_AVG_EXG_RATE_V1/?query_params`

Some web services are free to everyone, even without registering.  But most web services require you to register first and receive an **API Key**.  The API Key is a string that you include with every web service request.  You send your API Key as a query parameter or as part of an HTTP Header field (varies depending on the service).

## Using the CurrencyLayer.com Exchange Rate Service

[CurrencyLayer.com](https://currencylayer.com) has a free "live" exchange rate service.
To use it you need to sign up for an **API Key**, also called an *access key*.  Sign up for a free API Key at their [Product Sign-up Page](https://currencylayer.com/product) -- choose the "free" service, which is limited to "live" rates, uses USD as source currency, and limit of 1,000 queries/month.


The [Documentation][Documentation] describes how to use it, with examples.

The free service only converts from USD to other currencies, but we can use that to convert between any two currencies, just like we convert between any two Length units by using Meters as a base unit. For example, to convert from Thai Baht to Japanese Yen (THBJPY) we can use USDJPY/USDTHB.

To try the examples below, first register for a free API Key 
at [CurrencyLayer.com/product](https://currencylayer.com/product). 


## Service API Endpoint for Live Exchange Rate Service

The [Documentation][Documentation] page tells us the following:

* The API Endpoint is: `http://apilayer.net/api/live?query_parameters`
* The query parameters are:
    * access_key={your-access-key}
    * currencies=CODE1,CODE2,... such as currencies=THB,JPY.  If you omit this, it will return *all* exchange rates.
* The source currency is always USD (source=USD) in the free service
* There "Dashboard" shows that each HTTP request counts as one query regardless of how many currencies (or all currencies) you request.

## Sending a Trial Request

You can try it out in a web browser.  Just type in the URL with query parameters:
```
  http://apilayer.net/api/live?access_key=your-access-key-here&currencies=THB
```
You should get a reply like this, but all on one line:
```
{"success":true,"terms":"https://currencylayer.com/terms",
 "privacy":"https://currencylayer.com/privacy",
 "timestamp":1521862158,
 "source":"USD",
 "quotes":{"USDTHB":31.17037}
}
```

If you omit the `&currencies=THB` query parameter then it returns exchange rates for all currencies. The reply is:
```
{"success":true,"terms":"https://currencylayer.com/terms",
 "privacy":"https://currencylayer.com/privacy",
 "timestamp":1521947957,
 "source":"USD",
 "quotes":{"USDAED":3.672504,"USDAFN":68.930404,"USDALL":104.800003,
           "USDAMD":479.670013,"USDANG":1.780403,"USDAOA":214.358994,
           ... (more exchange rates) 
          }
}
```

If you send an invalid request, you'll either get an HTTP Response Code for the error (e.g. 404 for "not found") or a JSON reply like this:
```
{"success":false,
 "error":{"code":105,
 "info":"Access Restricted - Your current Subscription Plan does not support Source Currency Switching."}}
```

## Sending an Http Request using Java

The CurrencyLayer.com [Documentation][Documentation] page has a Java example using the popular Apache [HTTP Client](https://hc.apache.org/httpcomponents-client-ga/index.html) library that is part of [HTTPComponents](https://hc.apache.org/).  But the code is too long for such a simple task.

We can do the same thing with a lot less code by using the JDK's URL and HttpURLConnection classes. But it's still a lot longer than Python, which would require only about 3 lines of code!

You also need to *parse* the Http response to get the exchange rates. A simple, reliable way to do this is using a *regular expression* and the Java Matcher class.  The sample code explains how to do this.

## Java Sample Code

There is a sample project, with explanations, that shows you how to:

1. Send an HTTP request and read the response.
2. Parse the response to pick out the exchange rate info, using a regular expression.
3. Use a cache so you don't repeat the same web service requests.  

The CurrencyLayer.com service counts only the number of Http requests, so an efficient solution to just to get all the exchange rates in one query and cache them.

The sample project is at [https://github.com/jbrucker/currency-converter](https://github.com/jbrucker/currency-converter).


# References

* [Reading and Writing a URLConnection](https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html) - Oracle Java Tutorial.
* [Java HttpURLConnection Example](https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post) at JournalDev.com shows how to get the HTTP Response Code, set HTTP headers, and more.
* Another [Java HttpURLConnection Example](https://alvinalexander.com/blog/post/java/how-open-url-read-contents-httpurl-connection-java) with more detail and explanation.  The author has written several books about programming.



[Documentation]: https://currencylayer.com/documentation
