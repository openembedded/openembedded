DESCRIPTION = "XFS Filesystem Utilities"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPL"
SECTION = "base"
DEPENDS = "util-linux-ng"

SRC_URI = "ftp://oss.sgi.com/projects/xfs/cmd_tars/${P}.tar.gz"
SRC_URI[md5sum] = "86d10178ee6897cb099c97303e6d9da0"
SRC_URI[sha256sum] = "9128046ea978a65560b0e87406af9646a283fa0b54eab1801b971d8a89086ddd"

PARALLEL_MAKE = ""
inherit autotools
EXTRA_OECONF = "--enable-gettext=no"
TARGET_CC_ARCH += "${LDFLAGS}"


do_configure () {
	export LIBTOOL="${STAGING_BINDIR_NATIVE}/${HOST_SYS}-libtool"
	export DEBUG="-DNDEBUG"
	oe_runconf
}

do_install () {
	export DIST_ROOT=${D}
	oe_runmake install
}

