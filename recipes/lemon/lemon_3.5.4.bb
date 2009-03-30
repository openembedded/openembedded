require lemon.inc

PR = "r0"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 lemon ${D}${bindir}
	install -m 0644 lempar.c ${D}${bindir}
	install -d ${D}${mandir}/man1
	install -m 0644 ${WORKDIR}/lemon.1 ${D}${mandir}/man1/
}
