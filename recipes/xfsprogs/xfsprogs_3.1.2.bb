DESCRIPTION = "XFS Filesystem Utilities"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPL"
SECTION = "base"
DEPENDS = "util-linux-ng"
PR = "r2"

SRC_URI = "ftp://oss.sgi.com/projects/xfs/cmd_tars/${P}.tar.gz"
SRC_URI[md5sum] = "86d10178ee6897cb099c97303e6d9da0"
SRC_URI[sha256sum] = "9128046ea978a65560b0e87406af9646a283fa0b54eab1801b971d8a89086ddd"

PARALLEL_MAKE = ""
inherit autotools
EXTRA_OECONF = "--enable-gettext=no"
LIBTOOL = "${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"
TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN}-dev += "${base_libdir}/libhandle.la \
                    ${base_libdir}/libhandle.so"

do_configure () {
	export DEBUG="-DNDEBUG"
	oe_runconf
}

do_install () {
	export DIST_ROOT=${D}
	oe_runmake install
	# needed for xfsdump
	oe_runmake install-dev
	# replace extra links to /usr/lib with relative links (otherwise autotools_prepackage_lamangler fails to read nonexistent link)
	rm -f ${D}/${base_libdir}/libhandle.la
	rm -f ${D}/${base_libdir}/libhandle.a
	ln -s ../usr/lib/libhandle.la ${D}/${base_libdir}/libhandle.la
	ln -s ../usr/lib/libhandle.a ${D}/${base_libdir}/libhandle.a

	# and link from /usr/lib/libhandle.so to /lib/libhandle.so
	rm -f ${D}/${libdir}/libhandle.so
	ln -s ../../lib/libhandle.a ${D}/${libdir}/libhandle.so
}

