SECTION = "console/utils"
include stat_${PV}.bb
inherit native
S = "${WORKDIR}/stat-${PV}"

do_stage() {
	install -m 755 stat ${STAGING_BINDIR}

}

do_install() {
	true
}
