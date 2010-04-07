DESCRIPTION = "Simple Qt based stop watch"
AUTHOR = "Christof Musik"
SECTION = "x11/applications"
PRIORITY = "optional"
HOMEPAGE = "http://git.senfdax.de"
LICENSE = "GPL QPL"
DEFAULT_PREFERRENCE = "-1"
SRCREV = "89644b91e02151fc72989755f20c1ffb144ef5e2"
PV = "1.3.1+gitr${SRCREV}"
PR = "r0"

inherit qt4x11

SRC_URI = "git://git.senfdax.de/git/stopwatch;protocol=http"
S = "${WORKDIR}/git/"

do_configure() {
    ${OE_QMAKE_QMAKE}
}

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}stopwatch ${D}${bindir}
    install -d ${D}${datadir}/applications
    install ${S}desktop/stopwatch.desktop ${D}${datadir}/applications/
    install -d ${D}${datadir}/pixmaps
    install ${S}desktop/stopwatch.png ${D}${datadir}/pixmaps/
    install -d ${D}${datadir}/${PN}
    install ${S}desktop/om.style ${D}${datadir}/${PN}/
}
