DESCRIPTION = "LZMA is a general compression method. LZMA provides high compression ratio and very fast decompression."
HOMEPAGE = "http://www.7-zip.org/"
LICENSE = "LGPL"
DEPENDS = "zlib-native"
PR = "r3"

PVNODOT = "${@bb.data.getVar('PV',d,1).split('.')[0]}${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "${SOURCEFORGE_MIRROR}/sevenzip/lzma${PVNODOT}.tar.bz2 \
           file://lzma-406-zlib-stream.patch;patch=1;pnum=2"

S = "${WORKDIR}/SRC"

inherit native

CFLAGS += "-c -I${S}"

do_compile() {
        oe_runmake -C 7zip/Compress/LZMA_Alone
        oe_runmake -C 7zip/Compress/LZMA_Lib
}

do_stage () {
        install -m 0755 7zip/Compress/LZMA_Alone/lzma ${STAGING_BINDIR}
        oe_libinstall -a -C 7zip/Compress/LZMA_Lib liblzma ${STAGING_LIBDIR}
}
