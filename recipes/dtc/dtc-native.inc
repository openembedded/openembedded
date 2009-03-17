require dtc.inc

inherit native

do_stage() {
	install -m 755 dtc ${STAGING_BINDIR}/dtc
}

