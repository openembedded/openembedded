FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "c55a2b1eadf818d38e963060412fadca"
SRC_URI[sha256sum] = "11a53d332d2295f447ab49402a34d82875bbf5da8dc239ebb909eafdf3c26a36"
