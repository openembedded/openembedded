inherit autotools

DESCRIPTION = "Procinfo displays various system statistics including: memory \
used, free, swapped out; CPU time used for user applications, kernel \
(system), nice applications, idle; IRQs per second; page-in/out and \
swap-in/out per second, and disc activity."
HOMEPAGE = "http://sourceforge.net/projects/procinfo-ng/"
LICENSE = "LGPLv2.1 GPLv2"
DEPENDS = "ncurses"
PROVIDES += "procinfo"
RPROVIDES_${PN} += "procinfo"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/procinfo-ng/procinfo-ng-${PV}.tar.bz2 \
           file://obey-ldflags.patch"
SRC_URI[md5sum] = "ed018fe37becc36ceb1ebe3ed909c4d2"
SRC_URI[sha256sum] = "0cd944df90c1ea55b489ea64ec4863fe7f1a158f16660c58f94067e4f96786b0"
