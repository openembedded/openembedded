include treecc_${PV}.bb
SECTION = "devel"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/treecc-${PV}"
MAINTAINER = "Kirill Kononenko <krokas@aport.ru"
S = "${WORKDIR}/treecc-${PV}"

inherit native autotools

do_stage() {
	rm -f ${STAGING_BINDIR}/treecc
	install -m 0755 treecc ${STAGING_BINDIR}/
}
