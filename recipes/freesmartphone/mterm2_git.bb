DESCRIPTION = "mterm is a versatile muxer-aware terminal program"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/fso-term"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib readline libfsoframework libfsotransport"
LICENSE = "GPL"
PV = "0.1.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/cornucopia.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/tools/mterm2"

do_stage() {
	:
}

inherit autotools vala

FILES_${PN} += "${datadir}"
