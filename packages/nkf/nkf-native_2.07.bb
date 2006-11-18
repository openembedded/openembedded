require nkf_${PV}.bb
inherit native

do_stage() {
    install -m 0755 nkf ${STAGING_BINDIR}
}

do_install() {
	:
}

