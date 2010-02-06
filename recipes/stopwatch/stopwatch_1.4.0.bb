DESCRIPTION = "Simple Qt based stop watch"
AUTHOR = "Christof Musik"
SECTION = "x11/applications"
PRIORITY = "optional"
HOMEPAGE = "http://git.senfdax.de"
LICENSE = "GPL QPL"
PR = "r0"

inherit qt4x11

SRC_URI = "http://openmoko.senfdax.de/sources/${PN}-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "6cc756ea7a8fb94352eb2842d170f16c"
SRC_URI[archive.sha256sum] = "ef4fdbb3ab44e950a56c55e38dd5ffc449f736fb5d99d2befe5bbfc715bcb919"

do_configure() {
    ${OE_QMAKE_QMAKE}
}

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/stopwatch ${D}/${bindir}
    install -d ${D}/${datadir}/applications
    install ${S}/desktop/stopwatch.desktop ${D}/${datadir}/applications/
    install -d ${D}/${datadir}/pixmaps
    install ${S}/desktop/stopwatch.png ${D}/${datadir}/pixmaps/
    install -d ${D}/${datadir}/${PN}
    install ${S}/desktop/om.style ${D}/${datadir}/${PN}/
}
