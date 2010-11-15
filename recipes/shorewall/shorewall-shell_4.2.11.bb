require shorewall.inc

PR = "${INC_PR}.0"

# this version (4.2, legacy!) require only shell as parser

SRC_URI = " \
    http://www.shorewall.net/pub/shorewall/4.2/shorewall-${PV}/${PN}-${PV}.tar.bz2 \
    "

FILES_${PN} += "/usr/share/shorewall-shell/*"

SRC_URI[md5sum] = "518a7f389a6f606c109acb7dfbe18372"
SRC_URI[sha256sum] = "c85c8400015794b8fb191e519a0b8711028c865ca2b7e85099c7be26fe479e02"
