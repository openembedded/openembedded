DESCRIPTION = "Hardware Abstraction Layer device information"
HOMEPAGE = "http://freedesktop.org/Software/hal"
SECTION = "unknown"
LICENSE = "GPL AFL"

SRC_URI = "http://people.freedesktop.org/~david/dist/hal-info-20070618.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-recall --disable-video"

do_configure() {
        gnu-configize
	libtoolize --force
	oe_runconf
}


PACKAGE_ARCH = "all"
FILES_${PN} += "${datadir}/hal/"
