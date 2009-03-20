DESCRIPTION = "Reference implementation of the org.freesmartphone.Device.* APIs"
SECTION = "console/network"
DEPENDS = "libfsoframework"
LICENSE = "GPL"
PV = "0.0.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/cornucopia;protocol=git;branch=master \
"
S = "${WORKDIR}/git/fsodeviced"

inherit autotools fso-plugin vala
