DESCRIPTION = "Alsa OSS Compatibility Package"
SECTION = "libs/multimedia"
LICENSE = "GPL"
DEPENDS = "alsa-lib"
PR = "r1"

SRC_URI = "ftp://ftp.alsa-project.org/pub/oss-lib/alsa-oss-${PV}.tar.bz2 \
	   file://libio.patch;patch=1 \
	  "

inherit autotools_stage

LEAD_SONAME = "libaoss.so.0"

do_configure_prepend () {
	touch NEWS README AUTHORS ChangeLog
	sed -i "s/libaoss.so/${LEAD_SONAME}/" ${S}/alsa/aoss.in
}
