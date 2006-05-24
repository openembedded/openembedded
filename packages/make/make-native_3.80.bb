include make_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/make-${PV}"
S = "${WORKDIR}/make-${PV}"

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 755 make ${STAGING_BINDIR}
}
