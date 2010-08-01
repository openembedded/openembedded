#This is a development snapshot, so lets hint OE to use the releases
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "pixman virtual/libx11 libsm libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"

SRCREV = "3acccf0ea5ca1fde9cf6b91677588680a2644ee6"

PV = "1.9.3"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://git.cairographics.org/git/cairo;protocol=git \
	  "
inherit autotools pkgconfig

S = "${WORKDIR}/git"

do_compile_append() {
	cd ${S}/perf ; oe_runmake
}
