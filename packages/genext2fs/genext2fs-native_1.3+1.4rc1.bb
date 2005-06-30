include genext2fs_${PV}.bb
inherit native

do_stage () {
	install -m 0755 genext2fs ${STAGING_BINDIR}/
}

do_install () {
	:
}
