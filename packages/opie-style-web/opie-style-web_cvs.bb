DESCRIPTION = "A flatter widget style than flat :)"
SECTION = "opie/styles"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "webstyle"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/styles/web"
S = "${WORKDIR}/web"

inherit opie
