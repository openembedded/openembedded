DESCRIPTION = "Legacy Om calculator application."
SECTION = "openmoko/tools"
DEPENDS = "libmokoui2"
PV = "0.1.0+svnr${SRCPV}"
PR = "r1"

inherit openmoko2
LICENSE = "GPL"
SRC_URI += " file://openmoko-calculator.png "

do_install_append_openmoko() {
        install -d ${D}/${datadir}/pixmaps/
        install ${WORKDIR}//openmoko-calculator.png ${D}/${datadir}/pixmaps/openmoko-calculator.png
}
