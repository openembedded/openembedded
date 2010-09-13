DESCRIPTION = "XFS Filesystem Dump Utility"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPL"
SECTION = "base"
DEPENDS = "xfsprogs"
PR = "r1"

SRC_URI = "ftp://oss.sgi.com/projects/xfs/cmd_tars/${P}.tar.gz"
SRC_URI[md5sum] = "af6932cfcd95ce64dc583128a190ffd7"
SRC_URI[sha256sum] = "d3932f0d482f6f77ec8519ce24c00edbe006262751bfb4ad4b4bc3e219d807d1"

PARALLEL_MAKE = ""
inherit autotools
EXTRA_OECONF = "--enable-gettext=no"
TARGET_CC_ARCH += "${LDFLAGS}"

LIBTOOL = "${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"

do_configure () {
	export DEBUG="-DNDEBUG"
	oe_runconf
}

do_install () {
	export DIST_ROOT=${D}
	oe_runmake install
}

