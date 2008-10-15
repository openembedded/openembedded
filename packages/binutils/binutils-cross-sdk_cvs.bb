require binutils_cvs.bb
require binutils-cross-sdk.inc
FILE_PR = "r4"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-cvs"
