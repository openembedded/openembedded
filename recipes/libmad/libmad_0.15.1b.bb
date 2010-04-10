DESCRIPTION = "MPEG Audio Decoder Library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libid3tag"
LICENSE = "GPL"
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/mad/libmad-${PV}.tar.gz \
           file://add-pkgconfig.patch;patch=1 \
	   file://mad.diff;patch=1 \
	   file://mad-mips-h-constraint.patch;patch=1"

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

ARM_INSTRUCTION_SET = "arm"

SRC_URI[md5sum] = "1be543bc30c56fb6bea1d7bf6a64e66c"
SRC_URI[sha256sum] = "bbfac3ed6bfbc2823d3775ebb931087371e142bb0e9bb1bee51a76a6e0078690"
