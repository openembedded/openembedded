DESCRIPTION = "Opie datebook national holidays plugin"
SECTION = "opie/datebook"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "opie-datebook"
APPNAME = "nationaldayplugin"
MAINTAINER = "Team Opie <opie@handhelds.org>"

S = "${WORKDIR}/national"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/etc/nationaldays
	install -m 0644 ${WORKDIR}/nationaldays/*.xml ${D}${palmtopdir}/etc/nationaldays
}
