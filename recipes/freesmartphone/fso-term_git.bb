DESCRIPTION = "FSO Term is a versatile muxer-aware terminal program"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/fso-term"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib readline libfsotransport"
LICENSE = "GPL"
PV = "0.0.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/fso-term.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git"

inherit autotools vala

FILES_${PN} += "${datadir}"
