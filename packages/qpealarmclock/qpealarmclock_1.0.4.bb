DESCRIPTION = "Alarm Clock"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Dafydd Walters"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/applications-AlarmClock.html"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/qpealarmclock_V1.0.4.tar.gz \
	   file://qpealarm.patch;patch=1 \
	   file://fix-compile.patch;patch=1 "

S = "${WORKDIR}/qpealarmclock_V${PV}"
PR = "r1"

APPNAME = "qpealarmclock"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

inherit opie
