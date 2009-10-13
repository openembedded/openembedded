DESCRIPTION = "H.264 encoder"
LICENSE = "GPL"
PR = "r4"

X264PV = "snapshot-20090928-2245"

SRC_URI = "http://download.videolan.org/pub/videolan/x264/snapshots/x264-${X264PV}.tar.bz2"

S = "${WORKDIR}/${PN}-${X264PV}"

inherit autotools lib_package pkgconfig

# default --extra-cflags
X264_ECFLAGS = ""

# disable use of assembler written functions
X264_DISABLE_ASM = "--disable-asm"
# use assembler written functions for those archs supporting this
X264_DISABLE_ASM_x86 = ""
DEPENDS_x86 = "yasm-native"

EXTRA_OECONF = '--enable-shared ${X264_DISABLE_ASM} --extra-cflags="${X264_ECFLAGS}"'

do_stage() {
        autotools_stage_all
}
