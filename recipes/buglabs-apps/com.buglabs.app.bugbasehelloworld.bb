require bug-app.inc

DESCRIPTION = "*Changed this app to Beta since it appears to black out the BUGbase's base LCD*\
This is an application in the vein of Hello World for the BUGbase.  \
This is part of an effort to clarify the BUG's API, and how to use the API to make your own applications.  New users are encouraged to check out applications tagged with 'Hello World' to find similar programs for each of the modules.\
The application is extensively commented.\
What this application requires: nothing.  just your BUGbase or the virtual bug without modules.\
\
What this application does: when the bugbase is booted, or virtual bug started, and this application is sent to it, HelloWorld will display on the basedisplay.  This should work on the Virtual BUG and the physical BUG.\
What this application shows: some of the basic services required to interact with the BUGbase, and some ways to do it.\
See also: BaseDisgnostic, BUGbase\
"
HOMEPAGE = "http://buglabs.net/applications/BUGbase_helloworld"

DEPENDS += "com.buglabs.osgi service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/310"

APIVERSION = ""
