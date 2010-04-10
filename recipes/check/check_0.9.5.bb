DESCRIPTION = "a unit test framework for C"
LICENSE = "LGPL"
PRIORITY = "optional"
SECTION = "devel"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/check/check-${PV}.tar.gz \
           file://configure_fix.patch;patch=1"
S = "${WORKDIR}/check-${PV}"

inherit autotools_stage pkgconfig

EXTRA_OECONF += "--enable-plain-docdir"

SRC_URI[md5sum] = "30143c7974b547a12a7da47809a90951"
SRC_URI[sha256sum] = "961b3c66869018d02226bbbc394e79362cd898962ce810bce8417b3c497f7ad6"
