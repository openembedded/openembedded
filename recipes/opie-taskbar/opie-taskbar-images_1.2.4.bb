require ${PN}.inc

PR = "r2"
SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
