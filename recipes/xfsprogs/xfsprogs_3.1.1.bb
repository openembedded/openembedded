DESCRIPTION = "XFS Filesystem Utilities"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPL"
SECTION = "base"
PR = "r0"
DEPENDS = "util-linux-ng"

SRC_URI = "ftp://oss.sgi.com/projects/xfs/cmd_tars/xfsprogs-3.1.1.tar.gz;name=xfsprogstargz"
SRC_URI[xfsprogstargz.md5sum] = "c2308b46ee707597ac50aae418d321b8"
SRC_URI[xfsprogstargz.sha256sum] = "bc189022f720019d9e4aa9856772a4f89afa1cc4022f872b759fe001a8dd1e36"

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

