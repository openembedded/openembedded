require bug-app.inc

DESCRIPTION = "Updated!!!\
Multipart posts are now supported!\
This is a simple REST client you can use in your BUG Applications.  It provides a RESTful interface for using web services using java.net's HttpURLConnection and provides some extra utilities simply to make things easier.\
GET, PUT, POST, and HEAD are currently implemented.  An HTTP response that represents an error code (response code greater than 400) causes an HTTPException that stores the response code.  Some other abstractions and helpers are provided for dealing with the request and response.  There is also a class for creating a connection using HTTP Basic Authentication.  Check out the code, it is simple and pretty well documented.\
To use in your application download to your workspace and add simplerestclient to the Import-Package list in your application's manifest.\
Take a look at  TwitterBug_viaSimpleRESTClient to see how to use this.  Download both this application and TwitterBug_viaSimpleRESTClient to Dragonfly or your BUG."
HOMEPAGE = "http://buglabs.net/applications/SimpleRESTClient"

DEPENDS += "com.buglabs.osgi com.buglabs.common "

PV = "8"

SRC_LINK = "http://buglabs.net/program_version/download/325"

APIVERSION = ""
