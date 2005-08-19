inherit native
include findutils_${PV}.bb
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/findutils-${PV}"
S = "${WORKDIR}/findutils-${PV}"
