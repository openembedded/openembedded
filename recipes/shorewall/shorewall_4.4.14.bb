require shorewall.inc
# this version (4.4) requires some deps (perl)
require shorewall-deps.inc

PR = "${INC_PR}.0"

SRC_URI = " \
    http://www.shorewall.net/pub/shorewall/4.4/shorewall-${PV}/${PN}-${PV}.tar.bz2 \
    "

SRC_URI[md5sum] = "9f8705d69d42eb949e352af72c3af8bb"
SRC_URI[sha256sum] = "af097fc18c0d5a3b562812814107b627bfd3d802e3b5fe45fec4e53a4e84f17c"
