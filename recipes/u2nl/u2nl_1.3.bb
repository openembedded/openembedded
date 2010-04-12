DESCRIPTION = "u2nl (pronounce: "u-tunnel", universal tunnel) is capable of \
tunneling each and every TCP network connection from a Linux (2.4 and above, \
with netfilter) computer through an http CONNECT proxy."
HOMEPAGE = "http://www.reitwiessner.de/programs/u2nl.html"
LICENSE = "GPL"
SECTION = "console/network"
PRIORITY = "optional"

SRC_URI = "http://www.reitwiessner.de/programs/u2nl-${PV}.tar.gz \
	   file://buildsystem.patch;patch=1"
S = "${WORKDIR}/u2nl-${PV}"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[md5sum] = "d97a16d8b2231501ba418b5f1ffe018a"
SRC_URI[sha256sum] = "7e1d8239a5bd43c50f6091b484acbc8a7c5886cd4523f1e369504266cbaca50d"
