DESCRIPTION = "u2nl (pronounce: "u-tunnel", universal tunnel) is capable of \
tunneling each and every TCP network connection from a Linux (2.4 and above, \
with netfilter) computer through an http CONNECT proxy."
HOMEPAGE = "http://www.reitwiessner.de/programs/u2nl.html"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/network"
PRIORITY = "optional"

SRC_URI = "http://www.reitwiessner.de/programs/u2nl-${PV}.tar.gz \
	   file://buildsystem.patch;patch=1"
S = "${WORKDIR}/u2nl-${PV}"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}
