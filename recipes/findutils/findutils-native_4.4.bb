require findutils.inc

inherit native

DEFAULT_PREFERENCE = "-1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/findutils-${PV}"

S = "${WORKDIR}/findutils-${PV}"
