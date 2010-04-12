require xorg-lib-common.inc

DESCRIPTION = "FreeType-based font drawing library for X"
DEPENDS += "libxrender freetype fontconfig"
PROVIDES = "xft"
PR = "r1"
PE = "1"

XORG_PN = "libXft"

python do_package() {
        if bb.data.getVar('DEBIAN_NAMES', d, 1):
            bb.data.setVar('PKG_${PN}', 'libxft2', d)
        bb.build.exec_func('package_do_package', d)
}

FILES_${PN} = "${libdir}/lib*${SOLIBS}"
FILES_${PN}-dev = "${includedir} ${libdir}/lib*${SOLIBSDEV} ${libdir}/*.la \
		${libdir}/*.a ${libdir}/pkgconfig \
		${datadir}/aclocal ${bindir} ${sbindir}"

SRC_URI[archive.md5sum] = "1309301e2d979bd475dc58325cb8c056"
SRC_URI[archive.sha256sum] = "68b46f85caaf0b30c876bd983abe144c25755bee7532e8738ab7ebe29a428986"
