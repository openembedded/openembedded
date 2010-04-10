DESCRIPTION = "Alsa OSS Compatibility Package"
HOMEPAGE = "http://www.alsa-project.org"
SECTION = "libs/multimedia"
LICENSE = "GPL"
DEPENDS = "alsa-lib"
PR = "r0"

SRC_URI = "ftp://ftp.alsa-project.org/pub/oss-lib/alsa-oss-${PV}.tar.bz2"

inherit autotools

do_configure_prepend () {
	touch NEWS README AUTHORS ChangeLog
}

do_stage () {
	oe_libinstall -C alsa -a -so libaoss ${STAGING_LIBDIR}
	oe_libinstall -C alsa -a -so libalsatoss ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "3106c2d59a329263867fa3dd44133dda"
SRC_URI[sha256sum] = "6b688a3895a14945d0622e16cfdb9292ef9f953ab2d195b08595736f76e5a790"
