require notecase.inc

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -m 644 ${S}/docs/notecase.desktop ${D}${datadir}/applications
	install -m 755 ${S}/bin/notecase ${D}${bindir}/
}
