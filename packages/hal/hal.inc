DESCRIPTION = "Hardware Abstraction Layer"
HOMEPAGE = "http://freedesktop.org/Software/hal"
SECTION = "unknown"
LICENSE = "GPL LGPL AFL"

SRC_URI = "http://freedesktop.org/~david/dist/hal-${PV}.tar.gz"

S = "${WORKDIR}/hal-${PV}"

inherit autotools pkgconfig
