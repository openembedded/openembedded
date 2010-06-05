require binutils_cvs.bb
require binutils-cross.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-cvs"

do_install () {
        oe_runmake install-ld install-binutils install-gas
}
