DESCRIPTION = "LZMA is a general compression method. LZMA provides high compression ratio and very fast decompression."
HOMEPAGE = "http://www.7-zip.org/"
LICENSE = "LGPL"
DEPENDS = "zlib"
PR = "r1"

SRC_URI = "http://www.7-zip.org/dl/lzma417.tar.bz2 \
           file://lzma-406-zlib-stream.patch;patch=1;pnum=2"

S = "${WORKDIR}/SRC"

EXTRA_OEMAKE += "CXX_C='${CC}'"

CFLAGS += "-c -I${S}"

# If you run into "internal compiler error" failures with gcc, disable optimization
# using -O0, or use -O1 or -O2 instead of -Os. (reported failure: gcc 3.4.4 for sh4)
#FULL_OPTIMIZATION = "-O0"

# One such reported failure is a cross-gcc 3.4.4 for sh4:
FULL_OPTIMIZATION_sh4 = "-O1"

do_compile() {
        oe_runmake -C 7zip/Compress/LZMA_Alone
        oe_runmake -C 7zip/Compress/LZMA_Lib
}

do_install() {
        install -d ${D}${bindir} ${D}${libdir}
        install -m 0755 7zip/Compress/LZMA_Alone/lzma ${D}${bindir}
        oe_libinstall -a -C 7zip/Compress/LZMA_Lib liblzma ${D}${libdir}
}

do_stage () {
        oe_libinstall -a -C 7zip/Compress/LZMA_Lib liblzma ${STAGING_LIBDIR}
}
