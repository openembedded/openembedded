require qsvn.inc
FILESDIR += "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qsvn"
inherit qtopia4core
