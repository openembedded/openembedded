DESCRIPTION = "Mickey's DBus introspection and calling Program"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"

require python-helpers.inc

SRCREV = "${FSO_PYTHONHELPERS_SRCREV}"
PV = "0.9.2+gitr${SRCPV}"
PR = "r2"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 mickeydbus/mdbus ${D}${bindir}
}

RDEPENDS_${PN} = "\
  python-dbus \
  python-pygobject \
  python-pprint \
  python-xml \
"

PACKAGE_ARCH_${PN} = "all"

