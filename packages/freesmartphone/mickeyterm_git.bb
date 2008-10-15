DESCRIPTION = "Mickey's Terminal Program"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "console/network"
LICENSE = "GPLv2"
PV = "2.9.1+gitr${SRCREV}"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/python-helpers.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 mickeyterm/mickeyterm ${D}${bindir}
}

RDEPENDS_${PN} = "\
  python-readline \
  python-pyserial \
  python-textutils \
  python-threading \
"
RRECOMMENDS_${PN} += "\
  gsm0710muxd \
  python-dbus \
"

PACKAGE_ARCH_${PN} = "all"

