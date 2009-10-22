require upstart.inc

SRC_URI = "http://upstart.ubuntu.com/download/0.3/upstart-${PV}.tar.bz2 \
"

RRECOMMENDS_${PN} = "libupstart upstart-sysvcompat"

PR = "r1"
