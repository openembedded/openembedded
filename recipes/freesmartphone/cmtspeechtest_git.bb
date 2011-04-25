DESCRIPTION = "cmtspeechdata library test"
SECTION = "devel"
LICENSE = "GPL"
SRCREV = "c7839fb454307bcd9228afc5596c7cdba78b3288"
DEPENDS = "libcmtspeechdata"
PV = "0.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/nokian900/cmtspeechtest"

inherit autotools

FILES_${PN} += "${datadir}"
