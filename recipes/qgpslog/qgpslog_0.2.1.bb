DESCRIPTION = "QGPSLog"
AUTHOR = "Christian Rüb"
HOMEPAGE = "http://git.senfdax.de/?p=qgpslog;a=summary"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL QPL PD"
DEPENDS = "librsvg-native"
PR = "r1"

SRC_URI = "http://openmoko.senfdax.de/sources/${PN}-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "c4469fa6a84b38cf38c0ecc1d71c2727"
SRC_URI[archive.sha256sum] = "198d0a5a995c30816dd2f7fc23c78b8d4d5c340f93480e78169282216479a607"


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
