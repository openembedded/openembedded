DESCRIPTION = "Library for parsing configuration files."
HOMEPAGE = "http://www.nongnu.org/confuse/"
LICENSE = "LGPL"
SECTION = "libs"

SRC_URI = "http://download.savannah.gnu.org/releases/confuse/confuse-${PV}.tar.gz \
           file://build-only-library.patch"
S = "${WORKDIR}/confuse-${PV}"

inherit autotools binconfig pkgconfig lib_package

EXTRA_OECONF = "--enable-shared"

SRC_URI[md5sum] = "4bc9b73d77ebd571ac834619ce0b3582"
SRC_URI[sha256sum] = "65451d8d6f5d4ca1dbd0700f3ef2ef257b52b542b3bab4bbeddd539f1c23f859"
