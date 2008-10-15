DESCRIPTION = "MPEG Audio Decoder Library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libid3tag"
LICENSE = "GPL"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/mad/libmad-${PV}.tar.gz \
           file://add-pkgconfig.patch;patch=1 \
	   file://mad.diff;patch=1 "

S = "${WORKDIR}/libmad-${PV}"

SRC_URI_append_avr32 = " file://libmad-0.15.1b-avr32-optimization.patch;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = "-enable-speed --enable-shared"
# The ASO's don't take any account of thumb...
EXTRA_OECONF_append_thumb = " --disable-aso --enable-fpm=default"
EXTRA_OECONF_append_arm = " --enable-fpm=arm"

do_configure_prepend () {
#	damn picky automake...
	touch NEWS AUTHORS ChangeLog
}

do_stage() {
	oe_libinstall -so libmad ${STAGING_LIBDIR}
	install -m 0644 mad.h ${STAGING_INCDIR}
}

ARM_INSTRUCTION_SET = "arm"
