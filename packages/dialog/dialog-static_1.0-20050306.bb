include dialog.inc
LDFLAGS += "-static"
S="${WORKDIR}/dialog-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/dialog-${PV}"
