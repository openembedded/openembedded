DESCRIPTION = "The Opie Quick Launcher Loader"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/tools/quicklauncher"
S = "${WORKDIR}/quicklauncher"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 755 quicklauncher ${D}${palmtopdir}/bin/

}
