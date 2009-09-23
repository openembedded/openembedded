require findutils.inc

inherit native

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/findutils-${PV}"

SRC_URI += "file://mkinstalldirs.patch;patch=1"

S = "${WORKDIR}/findutils-${PV}"
