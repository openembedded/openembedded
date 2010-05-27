DESCRIPTION = "Multiple cat utility"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console"

require python-helpers.inc

SRCREV = "${FSO_PYTHONHELPERS_SRCREV}"
PV = "0.0.0+gitr${SRCPV}"
PR = "r1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 multicat/multicat ${D}${bindir}
}

RDEPENDS_${PN} = "\
  python-core \
"

PACKAGE_ARCH_${PN} = "all"
