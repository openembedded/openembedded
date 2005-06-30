DESCRIPTION = "The Opie Quick Launcher Loader"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

S = "${WORKDIR}/quicklauncher"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 755 quicklauncher ${D}${palmtopdir}/bin/

}
