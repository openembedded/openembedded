SECTION = "libs"
DESCRIPTION = "Library for reading mod-like audio files."

SRC_URI = "${SOURCEFORGE_MIRROR}/modplug-xmms/libmodplug-${PV}.tar.gz"
LICENSE = "GPL"
inherit autotools  pkgconfig

do_stage() {
	install -m 0644 ${S}/src/modplug.h ${STAGING_INCDIR}
#FIXME!
	cp -a src/.libs/libmodplug.so* ${STAGING_LIBDIR}
}
