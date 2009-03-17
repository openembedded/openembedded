DESCRIPTION = "Speex is an Open Source/Free Software patent-free audio compression format designed for speech."
SECTION = "libs/multimedia"
LICENSE = "BSD"
HOMEPAGE = "http://www.speex.org"
DEPENDS = "libogg"
BETA = "1.2rc1"
PV = "1.1+${BETA}"
PR = "r0"

SRC_URI = "http://downloads.us.xiph.org/releases/speex/speex-${BETA}.tar.gz"
S = "${WORKDIR}/speex-${BETA}"

PARALLEL_MAKE = ""

inherit autotools pkgconfig

LEAD_SONAME = "libspeex.so"

# Some interesting options are:
#
#	--enable-arm4-asm
#	--enable-arm5e-asm
#       --enable-blackfin-asm
#	--enable-fixed-point
#       --disable-float-api --disable-vbr (must disable-vbr if disable-float-api)
#

EXTRA_OECONF_append_openmn = " --enable-arm5e-asm --enable-fixed-point --disable-float-api --disable-vbr "
EXTRA_OECONF_append_amsdelta = " --enable-arm4-asm --enable-fixed-point --disable-float-api --disable-vbr "
EXTRA_OECONF_append_bfin = " --enable-blackfin-asm --enable-fixed-point --disable-float-api --disable-vbr "
EXTRA_OECONF_append_arm = " --enable-fixed-point --disable-float-api --disable-vbr "
EXTRA_OECONF_append_dht-walnut = " --enable-fixed-point --disable-float-api --disable-vbr "



do_configure_append() {
	sed -i s/"^OGG_CFLAGS.*$"/"OGG_CFLAGS = "/g Makefile */Makefile */*/Makefile
	sed -i s/"^OGG_LIBS.*$"/"OGG_LIBS = -logg"/g Makefile */Makefile */*/Makefile
	find . -name "Makefile" -exec sed -i s,-I/usr/include,, {} \;
}

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "${PN}-utils ${PN}-dsp"
FILES_${PN}-utils = "${bindir}/speex*"
FILES_${PN}-dsp = "${libdir}/libspeexdsp.so.*"
FILES_${PN} = "${libdir}/libspeex.so.*"
