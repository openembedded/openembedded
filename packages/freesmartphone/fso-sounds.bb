DESCRIPTION = "A set of notification sounds"
LICENSE = "PD"
SECTION = "multimedia"
PV = "0.0.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  http://gallium.prg.dtu.dk/HVSC/C64Music/MUSICIANS/G/Galway_Martin/Arkanoid_PSID.sid \
  ${FREESMARTPHONE_GIT}/artwork.git;protocol=git;branch=master \
"

do_install() {
	install -d ${D}${datadir}/sounds/
	install ${WORKDIR}/*.sid ${D}${datadir}/sounds/
	install ${WORKDIR}/git/sounds/*.mp3 ${D}${datadir}/sounds/
}

FILES_${PN} = "${datadir}"
PACKAGE_ARCH = "all"
