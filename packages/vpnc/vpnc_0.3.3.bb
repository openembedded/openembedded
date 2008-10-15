require vpnc.inc

PR = "r2"

SRC_URI = "http://www.unix-ag.uni-kl.de/~massar/vpnc/vpnc-${PV}.tar.gz \
           file://vpnc-script.patch;patch=1 \
           file://default.conf"
