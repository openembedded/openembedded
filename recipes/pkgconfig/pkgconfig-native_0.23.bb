require pkgconfig-0.23.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/pkgconfig-${PV}"

PR = "${INC_PR}.1"

inherit native
DEPENDS = ""
