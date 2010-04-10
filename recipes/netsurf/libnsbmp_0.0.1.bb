DESCRIPTION = "Libnsbmp is a decoding library for the BMP and ICO image file formats"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libnsbmp/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

SRC_URI = "http://www.netsurf-browser.org/projects/releases/libnsbmp-${PV}-src.tar.gz"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libnsbmp is only used by Netsurf
# at the moment

do_stage() {
	oe_libinstall -a -C build-OE/ libnsbmp ${STAGING_LIBDIR}
	install -m 0644 include/*.h ${STAGING_INCDIR}/
}

do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "61e1e5703580c1bc7d950a1aacea7bad"
SRC_URI[sha256sum] = "424d12aae7a6ea8c90438cf4ccff486dc01a3a2a7b68eb602ee2b8c28178b6d1"
