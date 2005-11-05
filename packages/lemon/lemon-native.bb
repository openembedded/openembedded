include lemon.inc
inherit native

do_stage () {
	install -d ${STAGING_BINDIR}
	install -m 0755 lemon ${STAGING_BINDIR}/
	install -d ${STAGING_DATADIR}/lemon
	install -m 0644 lempar.c ${STAGING_DATADIR}/lemon/
}
