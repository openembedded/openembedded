DESCRIPTION = "Libnsgif is a decoding library for the GIF image file format"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libnsgif/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

PR = "r1"

SRC_URI = "http://download.netsurf-browser.org/libs/releases/libnsgif-${PV}-src.tar.gz"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libnsbmp is only used by Netsurf
# at the moment

do_stage() {
	oe_libinstall -a -C build-OE/ libnsgif ${STAGING_LIBDIR}
	install -m 0644 build-OE/libnsgif.pc ${STAGING_LIBDIR}/pkgconfig
	install -m 0644 include/*.h ${STAGING_INCDIR}/
}

do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "08dd5fc3ea330784f6c1e55c58244749"
SRC_URI[sha256sum] = "dcb68be6a49ecc376cfa283d2f1e7eae035c75f99c0934ac80951e1777059617"
