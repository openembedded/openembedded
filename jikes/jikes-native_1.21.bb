SECTION = "devel"
inherit native
include jikes_${PV}.bb
S = "${WORKDIR}/jikes-${PV}"

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 755 src/jikes ${STAGING_BINDIR}
}
