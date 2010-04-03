inherit update-alternatives

do_install_append() {
	mv ${D}${bindir}/psplash ${D}${bindir}/psplash.${PN}
}

ALTERNATIVE_NAME = "psplash"
ALTERNATIVE_LINK = "${bindir}/psplash"
ALTERNATIVE_PATH = "${bindir}/psplash.${PN}"
