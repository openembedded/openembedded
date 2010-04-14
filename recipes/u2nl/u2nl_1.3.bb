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
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "5c26e620674932b4d1e50ba86f47a805"
#SRC_URI[sha256sum] = "d204bba10ce115d474d2d2ae3d027ddcbd10ad3909940a6779731d8df6c51c42"
