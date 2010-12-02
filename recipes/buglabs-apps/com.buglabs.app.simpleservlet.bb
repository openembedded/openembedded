require bug-app.inc

DESCRIPTION = "This application demonstrates how to contribute a Servlet to the OSGi runtime environment.  In order for this application to compile the Servlet API needs to be available to Eclipse. I've included servlet.jar in this application so it will compile.  In the future this will not be necessary.  After running the application in a Virtual BUG, connect a web browser to http://localhost:8082/SimpleServlet to verify it's working."
HOMEPAGE = "http://buglabs.net/applications/SimpleServlet"

DEPENDS += "com.buglabs.osgi.http com.buglabs.osgi service-tracker com.sun.javax.servlet com.buglabs.common "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/38"

APIVERSION = ""
