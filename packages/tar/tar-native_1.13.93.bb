SECTION = "base"
include tar_${PV}.bb
inherit native
S = "${WORKDIR}/tar-${PV}"

do_stage() {
	install -m 755 src/tar ${STAGING_BINDIR}
}

do_install() {
	true
}
