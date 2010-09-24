DESCRIPTION = "Speex is an Open Source/Free Software patent-free audio compression format designed for speech."
SECTION = "libs/multimedia"
LICENSE = "BSD"
HOMEPAGE = "http://www.speex.org"
DEPENDS = "libogg"
BETA = "1.2rc1"
PV = "1.1+${BETA}"
PR = "r2"

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

#check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require speex-fpu.inc
EXTRA_OECONF += "${@get_speex_fpu_setting(bb, d)}"

#ARMASM_armv4t = "--enable-arm4-asm"
#ARMASM_armv5te = "--enable-arm5e-asm"
ARMASM ?= ""

EXTRA_OECONF += "${ARMASM}"

do_configure_append() {
	sed -i s/"^OGG_CFLAGS.*$"/"OGG_CFLAGS = "/g Makefile */Makefile */*/Makefile
	sed -i s/"^OGG_LIBS.*$"/"OGG_LIBS = -logg"/g Makefile */Makefile */*/Makefile
	find . -name "Makefile" -exec sed -i s,-I/usr/include,, {} \;
}

PACKAGES =+ "${PN}-utils ${PN}-dsp"
FILES_${PN}-utils = "${bindir}/speex*"
FILES_${PN}-dsp = "${libdir}/libspeexdsp.so.*"
FILES_${PN} = "${libdir}/libspeex.so.*"

SRC_URI[md5sum] = "c4438b22c08e5811ff10e2b06ee9b9ae"
SRC_URI[sha256sum] = "342f30dc57bd4a6dad41398365baaa690429660b10d866b7d508e8f1179cb7a6"
