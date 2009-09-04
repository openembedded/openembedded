require tar_${PV}.bb
inherit native

do_stage() {
	install -m 755 src/tar ${STAGING_BINDIR}
}

do_install() {
	true
}
