DESCRIPTION = "libConfig++ is a portable and flexible C++ library for \
reading configuration files which were written in C style syntax."
SECTION = "libs"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/config-plus/config-plus-${PV}.tar.gz"
S = "${WORKDIR}/config-plus-${PV}"

inherit autotools



SRC_URI[md5sum] = "f7315c3dfcdf9e99bab9ece04187abef"
SRC_URI[sha256sum] = "bda6160e106ab9ee7ab53b3b9995515cae121c2c1f73ffb9786fb6237ab5e3fe"
