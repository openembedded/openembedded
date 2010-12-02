require bug-app.inc

DESCRIPTION = "A simple app that lists consumable OSGi services as discovered by jSLP.  Requires several bundles to work including jSLP core, jSLP discovery, and the R-OSGi bundles."
HOMEPAGE = "http://buglabs.net/applications/Remote+Service+Logger"

DEPENDS += "com.buglabs.osgi ch.ethz.iks.slp service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/444"

APIVERSION = ""

BROKEN = "1"
