FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-2.18"
require binutils_${PV}.bb
require binutils-cross.inc
