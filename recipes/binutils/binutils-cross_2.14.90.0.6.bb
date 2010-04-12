FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "71b99dba3045a359dc314dbebedcf502"
SRC_URI[sha256sum] = "6f75f36f35d16fd1fdc6600926af3ceaaa3bdca4e91ae3bf22891594afa0116e"
