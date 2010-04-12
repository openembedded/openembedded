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

SRC_URI[md5sum] = "99870531113dafd01026c01a96c5fcbb"
SRC_URI[sha256sum] = "8b435c02ed0a09d039c0a89c8ddc5470e1885630a5dcedfe3d8bc60a6d63ab69"
