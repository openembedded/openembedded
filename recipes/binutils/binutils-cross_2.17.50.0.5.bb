FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

SRC_URI[md5sum] = "00eccd47e19a9f24410a137a849aa3fc"
SRC_URI[sha256sum] = "bbfa06ee0173c5e9ae65ff14ba29502ddf4e355ac3419f88e3346299cfaf4e19"
