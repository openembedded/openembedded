DESCRIPTION = "parted, the GNU partition resizing program"
HOMEPAGE = "http://www.gnu.org/software/parted/parted.html"
LICENSE = "GPLv2"
SECTION = "console/tools"
DEPENDS = "readline e2fsprogs-libs"
PR = "r1"

SRC_URI = "${GNU_MIRROR}/parted/parted-${PV}.tar.gz"
           
EXTRA_OECONF = "--disable-Werror"

inherit autotools pkgconfig

do_configure() {
        libtoolize --force
        gnu-configize
        oe_runconf
}

do_stage() {
	autotools_stage_all
}

# Requires autoconf 2.61. Without it, will build, but there
# will be link errors when some other package will link against
# libparted.
DEFAULT_PREFERENCE = "-1"
