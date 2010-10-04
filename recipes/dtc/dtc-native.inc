require dtc.inc

inherit native

NATIVE_INSTALL_WORKS = "1"

do_install() {
	install -d ${D}${bindir}
	install -m 755 dtc ${D}${bindir}/
}
