require vpnc.inc

PR = "r0"

SRC_URI = "http://www.unix-ag.uni-kl.de/~massar/vpnc/vpnc-${PV}.tar.gz \
           file://makeman.patch;patch=1 \
           file://vpnc${PV}--long-help \
           file://default.conf"
