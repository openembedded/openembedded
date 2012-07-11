DESCRIPTION = "Libnsbmp is a decoding library for the BMP and ICO image file formats"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libnsbmp/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

PR = "r1"

SRC_URI = "http://download.netsurf-browser.org/libs/releases/libnsbmp-${PV}-src.tar.gz"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libnsbmp is only used by Netsurf
# at the moment

do_stage() {
	oe_libinstall -a -C build-OE/ libnsbmp ${STAGING_LIBDIR}
	install -m 0644 build-OE/libnsbmp.pc ${STAGING_LIBDIR}/pkgconfig
	install -m 0644 include/*.h ${STAGING_INCDIR}/
}

do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "6196f5223f744c7c6493421d205e591c"
SRC_URI[sha256sum] = "b18b9252b274699379cadff398e40c727930c9fcfb6bcf8ed3d346e7a93c720e"
