DESCRIPTION = "QGPSLog"
AUTHOR = "Christian Rüb"
HOMEPAGE = "http://git.senfdax.de/?p=qgpslog;a=summary"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL QPL PD"
DEPENDS = "librsvg-native"
PR = "r0"

SRC_URI = "http://openmoko.senfdax.de/sources/${PN}-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "26254f2dafc31260f65a8457ff7eada5"
SRC_URI[archive.sha256sum] = "3f7ef5e1b59f3d75c064d184ff0f91b149c2abfb7e996f70c8f39da8d96383e9"


inherit qt4x11

do_configure() {
    ${OE_QMAKE_QMAKE}
}

do_compile() {
    oe_runmake
    oe_runmake -C desktop
}

do_install() {
    install -d ${D}/${datadir}/pixmaps
    install ${S}/desktop/${PN}.png ${D}/${datadir}/pixmaps/
    install -d ${D}${bindir}
    install -m 0755 ${S}/qgpslog ${D}${bindir}
    install -d ${D}/${datadir}/${PN}
    install ${S}/styles/shr.style ${D}/${datadir}/${PN}/
    install -d ${D}/${datadir}/applications
    install ${S}/desktop/${PN}.desktop ${D}/${datadir}/applications/
}
