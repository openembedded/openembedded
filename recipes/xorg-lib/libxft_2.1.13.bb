require xorg-lib-common.inc

DESCRIPTION = "FreeType-based font drawing library for X"
DEPENDS += "libxrender freetype fontconfig"
PROVIDES = "xft"
PR = "r0"
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

SRC_URI[archive.md5sum] = "bc8881851f3bd8dcc625fac37350a1c6"
SRC_URI[archive.sha256sum] = "ce7688258af34c14af421bcfb306d4310245b727d2417ac968b7f6b2facfde8c"
