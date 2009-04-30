
SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git \
           file://configurefix.patch;patch=1"
PV = "0.0+gitr${SRCPV}"
PR = "r1"
PE = "1"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/desktop-directories/*"

inherit autotools_stage
