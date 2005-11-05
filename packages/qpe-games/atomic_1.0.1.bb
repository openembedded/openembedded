DESCRIPTION = "Atomic"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"

LICENSE = "GPL"
AUTHOR = "Andre Wuest"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Atomic.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/atomic_V1.0.1.tar.gz \
	   file://atomic.patch;patch=1"


PV = "1.0.1"
S = "${WORKDIR}/atomic_V${PV}"
APPNAME = "atomic"
APPTYPE = "binary"
APPDESKTOP = "${S}"




do_compile_prepend() {
	oe_runmake -C images
	oe_runmake -C tools
	oe_runmake -C levels
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

inherit opie
