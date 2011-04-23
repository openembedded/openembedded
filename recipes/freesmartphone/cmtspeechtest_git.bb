DESCRIPTION = "cmtspeechdata library test"
SECTION = "devel"
LICENSE = "GPL"
SRCREV = "509d02ca46087c23c18de81078b6ffcbd91a52d4"
DEPENDS = "libcmtspeechdata"
PV = "0.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/nokian900/cmtspeechtest"

inherit autotools

FILES_${PN} += "${datadir}"
