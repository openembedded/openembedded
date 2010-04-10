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

SRC_URI[md5sum] = "091bd1168a524a4f36fc61f95209e7e4"
SRC_URI[sha256sum] = "84890249b3ecf12ef040b9121b6238248fc8da0fee948661d70375049e5131ee"
