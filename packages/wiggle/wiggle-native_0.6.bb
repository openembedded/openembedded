SECTION = "unknown"
include wiggle_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/wiggle-${PV}"
