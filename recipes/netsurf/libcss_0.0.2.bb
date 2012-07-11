DESCRIPTION = "LibCSS is a CSS parser and selection engine, written in C"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libcss/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "libwapcaplet"

PR = "r1"

SRC_URI = "http://download.netsurf-browser.org/libs/releases/libcss-${PV}-src.tar.gz \
	   file://no-werror.patch"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libnsbmp is only used by Netsurf
# at the moment

do_stage() {
	oe_libinstall -a -C build-OE/ libcss ${STAGING_LIBDIR}
	install -m 0644 build-OE/libcss.pc ${STAGING_LIBDIR}/pkgconfig
	install -d ${STAGING_INCDIR}/libcss
	install -m 0644 include/libcss/*.h ${STAGING_INCDIR}/libcss
}

do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "3bbdd853a2f52db7ab0e2ea3597e62fa"
SRC_URI[sha256sum] = "5205351cb3231173eded5885c22cb7d1c26ae66d3c30c48e2fb826719d78989a"
