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

SRC_URI[md5sum] = "89ba368c8455c324d208e5f5965f8f8f"
SRC_URI[sha256sum] = "e622c344f72c6d95e15db834efbf777392778b2854e58a5d8f5d20b668cf2a9b"
