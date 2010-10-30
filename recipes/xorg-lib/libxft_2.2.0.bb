require xorg-lib-common.inc
DESCRIPTION = "FreeType-based font drawing library for X"
DEPENDS += "libxrender freetype fontconfig"
PE = "1"
PR = "${INC_PR}.0"

#SRC_URI += "file://autotools.patch"
SRC_URI[archive.md5sum] = "cce3c327258116493b753f157e0360c7"
SRC_URI[archive.sha256sum] = "c8685ae56da0c1dcc2bc1e34607e7d76ae98b86a1a71baba3a6b76dbcf5ff9b2"

FILES_${PN} = "${libdir}/lib*${SOLIBS}"
FILES_${PN}-dev = "${includedir} ${libdir}/lib*${SOLIBSDEV} ${libdir}/*.la \
                ${libdir}/*.a ${libdir}/pkgconfig \
                ${datadir}/aclocal ${bindir} ${sbindir}"

python do_package() {
        if bb.data.getVar('DEBIAN_NAMES', d, 1):
            bb.data.setVar('PKG_${PN}', 'libxft2', d)
        bb.build.exec_func('package_do_package', d)
}

XORG_PN = "libXft"
