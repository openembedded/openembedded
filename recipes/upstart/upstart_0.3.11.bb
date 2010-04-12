require upstart.inc

SRC_URI = "http://upstart.ubuntu.com/download/0.3/upstart-${PV}.tar.bz2 \
"

RRECOMMENDS_${PN} = "libupstart upstart-sysvcompat"

PR = "r1"

SRC_URI[md5sum] = "a9e475e1458c876add0441d9d4cfe9c0"
SRC_URI[sha256sum] = "d4f7fff9112049eab318518719735d0ac66ff558ed91c2d7c7c41124de2832b6"
