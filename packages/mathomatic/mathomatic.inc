DESCRIPTION = "A small, portable, general purpose CAS (Computer Algebra System)."
HOMEPAGE = "http://mathomatic.orgserve.de/math/"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "readline"

inherit autotools

EXTRA_OEMAKE = "READLINE=1"

do_install () {
	oe_runmake prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		docdir="${D}${docdir}/${PN}" \
		install
}
