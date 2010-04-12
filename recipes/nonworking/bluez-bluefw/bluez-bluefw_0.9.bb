SECTION = "libs"

SRC_URI = "http://bluez.sourceforge.net/download/${PN}-${PV}.tar.gz"
S = ${WORKDIR}/${P}

inherit autotools


SRC_URI[md5sum] = "69bf9e08d496c5ff46ad66f4d3d9934e"
SRC_URI[sha256sum] = "64f01789ff2f07bef386e552b78da110fb73128c3f18e8d4680708e00f29efad"
