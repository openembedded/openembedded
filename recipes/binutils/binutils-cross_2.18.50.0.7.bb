FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "d5bce238060d631be60a3f1f1009a7ba"
SRC_URI[sha256sum] = "6fe3c4b2d45a50582f832bc77deb4e3da74a15ea8e09dbb214b9c44e7c3378fc"
