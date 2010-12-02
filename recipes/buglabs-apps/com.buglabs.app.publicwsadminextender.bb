require bug-app.inc

DESCRIPTION = "Use this instead of PublicWSAdmin to publish web services on the BUG.  \
When you register your PublicWSProviders with this service, it gives the same XML list of services that PublicWSAdmin provides at http://[bug url]/service but it also gives an HTML view of the list at http://[bug_url]/service.html.\
To see how to use this, see the example application at 'http://buglabs.net/applications/SimpleConciergeLogViewerXWS(http://buglabs.net/applications/SimpleConciergeLogViewerXWS)':http://buglabs.net/applications/SimpleConciergeLogViewerXWS"
HOMEPAGE = "http://buglabs.net/applications/PublicWSAdminExtender"

DEPENDS += "com.buglabs.osgi.http com.buglabs.osgi service-tracker com.sun.javax.servlet com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/752"

APIVERSION = ""
