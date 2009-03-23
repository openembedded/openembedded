unionutils = "unionctl uniondbg"

include unionfs.inc

SECTION = "kernel/userland"

do_compile () {
	oe_runmake ${unionutils}
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 ${unionutils} ${D}${sbindir}/

	install -d ${D}${mandir}/man8
	for m in ${unionutils}; do
		install -m 0644 man/$m.8 ${D}${mandir}/man8/ || exit 1
	done
}

FILES_${PN} = "${sbindir}/unionctl"
FILES_${PN}-dev = "${sbindir}/uniondbg"

