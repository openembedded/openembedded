require lemon.inc

PR = "r0"

inherit native

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 0755 lemon ${STAGING_BINDIR}
	install -m 0644 lempar.c ${STAGING_BINDIR}
}
