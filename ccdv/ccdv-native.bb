include ccdv.bb
inherit native

do_stage () {
	install -m 0755 ccdv ${STAGING_BINDIR}/
}

do_install () {
	:
}
