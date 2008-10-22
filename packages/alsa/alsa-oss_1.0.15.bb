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
