DESCRIPTION = "X FreeType library. Client-side fonts with FreeType."
LICENSE = "MIT-X"
SECTION = "x11/libs"

DEPENDS = "libx11 xproto libxrender freetype fontconfig"
PROVIDES = "xft"


XORG_PN = "libXft"

include xorg-xlibs.inc

FILES_${PN} = ${libdir}/lib*.so.*
FILES_${PN}-dev = ${includedir} ${libdir}/lib*.so ${libdir}/*.la \
		${libdir}/*.a ${libdir}/pkgconfig \
		${datadir}/aclocal ${bindir} ${sbindir}

python do_package() {
        if bb.data.getVar('DEBIAN_NAMES', d, 1):
            bb.data.setVar('PKG_${PN}', 'libxft2', d)
        bb.build.exec_func('package_do_package', d)
}
