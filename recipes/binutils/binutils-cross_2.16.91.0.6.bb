FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "00ef9f1429d5f18702d08552f5c09441"
SRC_URI[sha256sum] = "7cffa91af850d3fd5f086e3690eae05c1d9d5ad82f915b36f0de920a3c9920be"
