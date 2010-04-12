DESCRIPTION = "Alsa OSS Compatibility Package"
SECTION = "libs/multimedia"
LICENSE = "GPL"
DEPENDS = "alsa-lib"
PR = "r2"

SRC_URI = "ftp://ftp.alsa-project.org/pub/oss-lib/alsa-oss-${PV}.tar.bz2 \
	   file://libio.patch;patch=1 \
	  "

inherit autotools 

LEAD_SONAME = "libaoss.so.0"

do_configure_prepend () {
	touch NEWS README AUTHORS ChangeLog
}

do_stage () {
	oe_libinstall -C alsa -a -so libaoss ${STAGING_LIBDIR}
	oe_libinstall -C alsa -a -so libalsatoss ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "49fb5fbae8bf955b248e46ff9c9a2aa1"
SRC_URI[sha256sum] = "85245d7666d82cc44010dfe14f6427a8586da2c8b033fb636f0f041dd7e5168b"
