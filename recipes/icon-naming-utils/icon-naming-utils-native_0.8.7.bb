LICENSE = "GPLv2"
DEPENDS = "libxml-simple-perl-native"

SRC_URI = "http://tango.freedesktop.org/releases/icon-naming-utils-${PV}.tar.gz"

S = "${WORKDIR}/icon-naming-utils-${PV}"

inherit autotools native
