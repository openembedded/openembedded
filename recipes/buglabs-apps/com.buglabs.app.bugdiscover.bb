require bug-app.inc

DESCRIPTION = "h4. Upgrade\
The newest version is now a service bundle, download  the ' demo app (Demo)':http://www.buglabs.net/applications/BugDiscoverDemo to see how it works . \
This is a very simple app that uses (and includes) JmDNS to discover BUGs. * It will only discover bugs running RC1.4.3 and above*.\
The code was written very quickly to show my co-workers how awesome life can be with avahi."
HOMEPAGE = "http://buglabs.net/applications/BUGDiscover"

DEPENDS += "com.buglabs.common "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/1034"

APIVERSION = "1.4.3"
