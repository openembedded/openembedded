DESCRIPTION = "Mickey's Terminal Program"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"

require python-helpers.inc

SRCREV = "${FSO_PYTHONHELPERS_SRCREV}"
PV = "2.9.1+gitr${SRCPV}"
PR = "r3"

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
  fso-gsm0710muxd \
  python-dbus \
"

PACKAGE_ARCH_${PN} = "all"
