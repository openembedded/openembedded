DESCRIPTION = "A Calculator for Openmoko"
SECTION = "openmoko/tools"
DEPENDS = "libmokoui2"
PV = "0.1.0+svnr${SRCREV}"
PR = "r1"

inherit openmoko2
SRC_URI += " file://openmoko-calculator.png "

do_install_append_openmoko() {
        install -d ${D}/${datadir}/pixmaps/
        install ${WORKDIR}//openmoko-calculator.png ${D}/${datadir}/pixmaps/openmoko-calculator.png
}

PKG_TAGS_${PN} = "group::unknown alias::Om_Calculator"
