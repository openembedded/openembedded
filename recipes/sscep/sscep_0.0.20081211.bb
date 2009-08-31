DESCRIPTION = "Simple SCEP Client for Unix"
SECTION = "console/utils"
LICENSE = "BSD"

SRC_URI = " \
	http://www.klake.org/~jt/sscep/sscep.tgz \
	file://memleak.patch;patch=1 \
	file://httphost.patch;patch=1 \
	file://ca_segfault.patch;patch=1 \
"

S = "${WORKDIR}/${PN}"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 sscep ${D}${bindir}/sscep
}
