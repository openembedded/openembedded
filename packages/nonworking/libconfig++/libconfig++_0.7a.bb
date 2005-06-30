DESCRIPTION = "libConfig++ is a portable and flexible C++ library for \
reading configuration files which were written in C style syntax."
SECTION = "libs"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/config-plus/config-plus-${PV}.tar.gz"
S = "${WORKDIR}/config-plus-${PV}"
 
inherit autotools


