require vpnc.inc

PR = "r2"

SRC_URI = "http://www.unix-ag.uni-kl.de/~massar/vpnc/vpnc-${PV}.tar.gz \
           file://vpnc-script.patch;patch=1 \
           file://default.conf"

SRC_URI[md5sum] = "e7518cff21326fe7eb9795b60c25ae6a"
SRC_URI[sha256sum] = "be4a8e87b044cb99349e71e6879446739dd537dbde13e99ec61817ed67605bd7"
