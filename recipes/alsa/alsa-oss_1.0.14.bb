DESCRIPTION = "Alsa OSS Compatibility Package"
SECTION = "libs/multimedia"
LICENSE = "GPL"
DEPENDS = "alsa-lib"

SRC_URI = "ftp://ftp.alsa-project.org/pub/oss-lib/alsa-oss-${PV}.tar.bz2"

inherit autotools 

do_configure_prepend () {
	touch NEWS README AUTHORS ChangeLog
}

do_stage () {
	oe_libinstall -C alsa -a -so libaoss ${STAGING_LIBDIR}
	oe_libinstall -C alsa -a -so libalsatoss ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "a24475b978982ff8cb2f25be793c6b83"
SRC_URI[sha256sum] = "c8feb3eb9d4255a4aff7ca839555293c237c1b2f034c118127e826843c6f0184"
