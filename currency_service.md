---
layout: page
title: Currency Converter
---
## Create a Currency Converter

You can define a kind of Unit in your Converter that converts currencies.  
Its not hard and the code is not that long.  You'll learn how to use a web service
and send HTTP requests from Java code.

To do this, you need:

* Access to a web service to get currency rates
* Java code to send a request and read the response. You can use URL and HttpURLConnection, which are part of the Java API.

## What's a Web Service?

A web service is a network service that uses the standard HTTP or HTTPS protocol of the web, but is designed to be called from within a program instead of from a web browser.  Web services return data in a format that's useful for software instead of web pages (HTML).

The common data formats returned by web services are:

* plain text, such as:
  ```
  USDTHB=31.17037
  ```
* JSON, a key-value textual representation of data, such as this:
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

To invoke a web service, you send an HTTP or HTTPS request to a URL.  For the above currency conversion, the request was (with xxxxxx instead of my actual API Key):
```
http://apilayer.net/api/live?access_key=xxxxxxx&currencies=THB,JPY
```

## Free Currency Exchange Rate Services

There are a few free exchange rate services on the net. If you find another one, please tell me.  Two are:

1. [currencylayer.com](https://currencylayer.com) has a limited free currency conversion. The "source" currency is always USD in the free service, but you can convert to as many other currencies as you want.
2. [Bank of Thailand API](https://iapi.bot.or.th/Developer) has daily average exchange rate between Thai Baht (THB) and other currencies.

## How to Use a Web Service

For "RESTful" web services, you just send an ordinary HTTP request message with query parameters for the information you want.  The URL identifies the service that you want. 
Here are two examples:

* CurrencyLayer.com Live Exchange Rate service: `http://apilayer.net/api/live?query_params`
* Bank of Thailand Daily Exchange Rate service: `https://iapi.bot.or.th/Stat/Stat-ExchangeRate/DAILY_AVG_EXG_RATE_V1/?query_params`

Some web services are free to everyone, even without registering.  But most web services require you to register first and receive an **API Key**.  The API KEy is a string that you include with every web service request.  You send your API Key as a query parameter or as part of an HTTP Header field (varies depending on the service).

## Using the CurrencyLayer.com Exchange Rate Service

[CurrencyLayer.com](https://currencylayer.com) has a free "live" exchange rate service.
To use it you need to sign up for an **API Key**, also called an *access key*.  Sign up for a free API Key on their [Product Sign-up Page](https://currencylayer.com/product) -- choose the "free" service, which is limited to "live" rates and uses USD as source currency.


The [Documentation][Documentation] describes how to use it, with examples.

The free service only converts from USD to other currencies, but we can use that to convert between any two currencies, just like we convert between any two Length units by using Meters as a base unit. For example, to convert from Thai Baht to Japanese Yen (THBJPY) we can use USDJPY/USDTHB.

To try the examples below, first register for a free API Key 
at [CurrencyLayer.com/product](https://currencylayer.com/product).  The free plan limits you to 1,000 queries per month and only the "live" service. (So be careful not to exceed your quota during testing.)


## Service API Endpoint for Live Exchange Rate Service

Their [Documentation][Documentation] page tells us the following:

* The API Endpoint is: `http://apilayer.net/api/live?query_parameters`
* The query parameters are:
    * access_key={your-access-key}
    * currencies=CODE1,CODE2,... such as currencies=THB,JPY.  If you omit this, it will return *all* exchange rates.
* The source currency is always USD (source=USD) in the free service

## Sending a Trial Request

You can try it out in a web browser.  Just type in the URL with query parameters:
```
  http://apilayer.net/api/live?access_key=xxxxxxxxxxxxxxxxxxxx&currencies=THB
```
You should get a reply like this but all on one line (web services are for *software programs* not *humans*):
```
{"success":true,"terms":"https:\/\/currencylayer.com\/terms",
 "privacy":"https:\/\/currencylayer.com\/privacy","timestamp":1521862158,
 "source":"USD",
 "quotes":{"USDTHB":31.17037}
}
```
If you send an invalid request, you 'll either get an HTTP Response Code for the error (like 404 for "not found") or a JSON reply containing `"success":false` like this:
```
{"success":false,"error":{"code":105,
 "info":"Access Restricted - Your current Subscription Plan does not support Source Currency Switching."}}
```

## Sending an Http Request using Java

The CurrencyLayer.com [Documentation][Documentation] page has a Java example using the popular Apache [HTTP Client](https://hc.apache.org/httpcomponents-client-ga/index.html) library that is part of [HTTPComponents](https://hc.apache.org/).  But the code is rather long for such a simple task.

You can do the same thing using the JDK's URL and HttpURLConnection classes (see references below).  The code is pretty short.  Well, "short" for Java -- it would be *much* shorter in Python.

You also need to *parse* the exchange rate from the Http response string. A reliable way to do this is using a *regular expression* and the Java Matcher class.

## Java Sample Code

To be added -- if anyone is interested.

Shows you how to do 3 things:

1. send an HTTP request and read the response data.
2. parse the response to pick out the exchange rate info, using a regular expression.
3. use a cache so you don't repeat the same web service requests.


## References

* [Reading and Writing a URLConnection](https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html) - Oracle Java Tutorial.
* [Java HttpURLConnection Example](https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post) at JournalDev.com shows how to get the HTTP Response Code, set HTTP headers, and more.
* Another [Java HttpURLConnection Example](https://alvinalexander.com/blog/post/java/how-open-url-read-contents-httpurl-connection-java) with more detail and explanation.  The author has written several books about programming.



[Documentation]: https://currencylayer.com/documentation
