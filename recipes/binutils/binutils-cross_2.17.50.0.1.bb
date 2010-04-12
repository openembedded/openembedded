FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "cfecfb29e260225fa192654f3763c2f8"
SRC_URI[sha256sum] = "9a56b06e4f533745e9b7cde5b170f905f74d130b899f48498cbd6d376c664b7a"
