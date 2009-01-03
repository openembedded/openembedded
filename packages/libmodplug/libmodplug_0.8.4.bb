DESCRIPTION = "Library for reading mod-like audio files."
HOMEPAGE = "http://modplug-xmms.sf.net"
SECTION = "libs"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/modplug-xmms/libmodplug-${PV}.tar.gz"

inherit autotools pkgconfig

# NOTE: autotools_stage_all does nothing here, we need to do it manually
do_stage() {
	install -m 0644 ${S}/src/modplug.h ${STAGING_INCDIR}
	oe_libinstall -C src -so libmodplug ${STAGING_LIBDIR}
}
