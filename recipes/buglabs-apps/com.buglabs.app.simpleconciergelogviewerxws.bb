require bug-app.inc

DESCRIPTION = "This little app shows the Concierge Log in a browser when you go to http://[bug_ip]/service/ConciergeLogViewerWS .\
This application depends on PublicWSAdminExtender: 'http://buglabs.net/applications/PublicWSAdminExtender(http://buglabs.net/applications/PublicWSAdminExtender)':http://buglabs.net/applications/PublicWSAdminExtender\
This is a good, simple, tutorial app that shows how to use PublicWSAdminExtender, which publishes web services as xml and html."
HOMEPAGE = "http://buglabs.net/applications/SimpleConciergeLogViewerXWS"

DEPENDS += "com.buglabs.app.publicwsadminextender com.buglabs.osgi service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/753"

APIVERSION = ""
