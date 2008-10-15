PR = "r0"

S = "${WORKDIR}/make-${PV}"

inherit native

do_stage() {
        install -d ${STAGING_BINDIR}
        install -m 755 make ${STAGING_BINDIR}
}

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/make-${PV}"

require make_${PV}.bb
