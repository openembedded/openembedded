DESCRIPTION = "LZMA is a general compression method. LZMA provides high compression ratio and very fast decompression."
HOMEPAGE = "http://www.7-zip.org/"
LICENSE = "LGPL"
INC_PR = "r5"

SRC_URI = "http://downloads.sourceforge.net/sevenzip/lzma${@bb.data.getVar('PV',d,1).replace('.','')}.tar.bz2 \
           file://001-large_files.patch \
           file://002-lzmp.patch \
           file://003-compile_fixes.patch \
           file://100-static_library.patch"

S = "${WORKDIR}"

EXTRA_OEMAKE = "-f makefile.gcc"

CFLAGS += "-c -I${S}"

do_unpack_append() {
        # Replace MS-DOS line-endings with Unix style line-endings
        oe.process.run("find . -type f -print0 | xargs -0 sed 's/\r$//' -i",
                       cwd=d.getVar("S", True))
}

do_patch_append() {
        # Hack to ensure we use our environment values
        oe.process.run("find . -type f -name makefile.gcc -print0 | xargs -0 sed 's/^CXX =/CXX ?=/;s/^CXX_C =/CXX_C ?=/;s/CXX_C/CC/' -i",
                       cwd=d.getVar("S", True))
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

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
