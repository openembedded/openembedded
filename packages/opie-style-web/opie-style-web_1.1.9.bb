DESCRIPTION = "A flatter widget style than flat :)"
SECTION = "opie/styles"
PRIORITY = "optional"
LICENSE = "GPL"

APPNAME = "webstyle"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/styles/web"
S = "${WORKDIR}/web"

inherit opie
