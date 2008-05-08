DESCRIPTION = "Mickey's Terminal Program"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "python-serial"
LICENSE = "GPLv2"
PV = "2.9.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/python-helpers.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 mickeyterm/mickeyterm ${D}${bindir}
}

RDEPENDS_${PN} = "\
  python-readline \
  python-serial \
  python-textutils \
  python-threading \
"
RRECOMMENDS_${PN} += "\
  gsm0710muxd \
  python-dbus \
"
