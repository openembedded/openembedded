inherit update-alternatives

SRCREV = "${SRCREV_pn-psplash}"

do_install_append() {
	mv ${D}${bindir}/psplash ${D}${bindir}/psplash.${PN}
}

ALTERNATIVE_NAME = "psplash"
ALTERNATIVE_LINK = "${bindir}/psplash"
ALTERNATIVE_PATH = "${bindir}/psplash.${PN}"
