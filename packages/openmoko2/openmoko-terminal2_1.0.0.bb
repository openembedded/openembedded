DESCRIPTION = "The OpenMoko Command Line Console"
SECTION = "openmoko/applications"
RDEPENDS += "mrxvt"
PR = "r0"

inherit openmoko2

SRC_URI = "file://openmoko-terminal.png \
           file://openmoko-terminal.desktop"

do_install() {
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/openmoko-terminal.png ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/openmoko-terminal.desktop ${D}${datadir}/applications/
}
