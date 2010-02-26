DESCRIPTION = "Abyss is a GSM 07.10 muxer userspace daemon"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/Abyss"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "vala-native dbus dbus-glib libgsm0710mux"
LICENSE = "GPL"
PV = "0.9.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/fso-abyss.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${datadir}"
