FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "17a52219dee5a76c1a9d9b0bfd337d66"
SRC_URI[sha256sum] = "bd2ea10ffc2bf62a917b05f4fbe3d02212589c2bc177fa0c51a9c874d3da528a"
