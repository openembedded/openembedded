DESCRIPTION = "LZMA is a general compression method. LZMA provides high compression ratio and very fast decompression."
HOMEPAGE = "http://www.7-zip.org/"
LICENSE = "LGPL"
DEPENDS = "zlib"
INC_PR = "r1"

SRC_URI = "http://downloads.sourceforge.net/sevenzip/lzma${@bb.data.getVar('PV',d,1).replace('.','')}.tar.bz2 \
           file://001-large_files.patch;patch=1 \
           file://002-lzmp.patch;patch=1 \
           file://003-compile_fixes.patch;patch=1 \
           file://100-static_library.patch;patch=1"

S = "${WORKDIR}"

EXTRA_OEMAKE = "-f makefile.gcc"

CFLAGS += "-c -I${S}"

do_unpack_append() {
        # It has few files with wrong encoding
        os.system("find ${S} -type f -print0 | xargs -0 dos2unix")
}

do_compile() {
        oe_runmake -C C/LzmaUtil
        oe_runmake -C CPP/7zip/Compress/LZMA_Alone
}

do_install() {
        install -d ${D}${bindir} ${D}${libdir}
        install -m 0755 CPP/7zip/Compress/LZMA_Alone/lzma ${D}${bindir}
        oe_libinstall -a -C C/LzmaUtil liblzma ${D}${libdir}
}

do_stage () {
        install --d ${STAGING_INCDIR}/lzma
        install -m 0644 C/*.h ${STAGING_INCDIR}/lzma
        oe_libinstall -a -C C/LzmaUtil liblzma ${STAGING_LIBDIR}
}
