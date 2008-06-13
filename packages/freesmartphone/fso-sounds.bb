DESCRIPTION = "A set of notification sounds"
LICENSE = "PD"
SECTION = "multimedia"
PV = "0.0.0"
PR = "r0"

SRC_URI = "http://gallium.prg.dtu.dk/HVSC/C64Music/MUSICIANS/G/Galway_Martin/Arkanoid_PSID.sid"

do_install() {
	install -d ${D}${datadir}/sounds/
	install ${WORKDIR}/*.sid ${D}${datadir}/sounds/
}

FILES_${PN} = "${datadir}"
PACKAGE_ARCH = "all"
