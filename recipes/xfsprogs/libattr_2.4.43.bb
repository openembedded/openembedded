DESCRIPTION = "library functions to get attribute bits"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPL"
SECTION = "base"
PR = "r0"
DEPENDS = "gettext"

SRC_URI = "ftp://oss.sgi.com/projects/xfs/cmd_tars/attr_${PV}-1.tar.gz"
S = "${WORKDIR}/attr-${PV}"

PARALLEL_MAKE = ""
inherit autotools
EXTRA_OECONF = "--enable-gettext=no --enable-shared=yes"

do_configure () {
	export LIBTOOL="${STAGING_BINDIR_NATIVE}/${HOST_SYS}-libtool"
	export DEBUG="-DNDEBUG"
	oe_runconf
}

do_install () {
	export DIST_ROOT=${D}
	oe_runmake install
	oe_libinstall -a libattr ${D}${libdir}
	oe_libinstall -a libattr ${STAGING_LIBDIR}
}

