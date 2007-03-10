DESCRIPTION = "Library for parsing configuration files."
HOMEPAGE = "http://www.nongnu.org/confuse/"
LICENSE = "LGPL"
SECTION = "libs"

SRC_URI = "http://download.savannah.gnu.org/releases/confuse/confuse-${PV}.tar.gz \
           file://build-only-library.patch;patch=1"
S = "${WORKDIR}/confuse-${PV}"

inherit autotools binconfig pkgconfig lib_package

EXTRA_OECONF = "--enable-shared"

do_stage() {
    autotools_stage_all
}

