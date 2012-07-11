DESCRIPTION = "LibWapcaplet is a string internment library, written in C"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libwapcaplet/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

PR = "r1"

SRC_URI = "http://download.netsurf-browser.org/libs/releases/libwapcaplet-${PV}-src.tar.gz"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libnsbmp is only used by Netsurf
# at the moment

do_stage() {
	oe_libinstall -a -C build-OE/ libwapcaplet ${STAGING_LIBDIR}
	install -m 0644 build-OE/libwapcaplet.pc ${STAGING_LIBDIR}/pkgconfig
	install -d ${STAGING_INCDIR}/libwapcaplet
	install -m 0644 include/libwapcaplet/*.h ${STAGING_INCDIR}/libwapcaplet
}

do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "c73b5ff5fce55819cc698e8cb486d5eb"
SRC_URI[sha256sum] = "4246215ceff620a882d170b3ef4abaa04fcb4190122a62b6e9b3e662ab880869"
