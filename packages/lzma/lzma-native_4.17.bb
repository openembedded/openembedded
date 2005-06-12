DESCRIPTION = "LZMA is a general compression method. LZMA provides high compression ratio and very fast decompression."
HOMEPAGE = "http://www.7-zip.org/"
LICENSE = "LGPL"

SRC_URI = "http://www.7-zip.org/dl/lzma417.tar.bz2 \
	file://lzma-406-zlib-stream.patch;patch=1"
S = "${WORKDIR}"

inherit native

do_compile() {
	make -C ${S}/SRC/7zip/Compress/LZMA_Alone
	make -C ${S}/SRC/7zip/Compress/LZMA_Lib
}

do_stage () {
	install -m 0755 ${S}/SRC/7zip/Compress/LZMA_Alone/lzma ${STAGING_BINDIR}
	oe_libinstall -a ${S}/SRC/7zip/Compress/LZMA_Lib/liblzma ${STAGING_LIBDIR}
}
