require binutils_csl-arm-20050603.bb
require binutils-cross.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-cvs"
