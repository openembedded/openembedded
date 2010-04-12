require vpnc.inc

PR = "r1"

SRC_URI = "http://www.unix-ag.uni-kl.de/~massar/vpnc/vpnc-${PV}.tar.gz \
           file://makeman.patch;patch=1 \
           file://vpnc-install.patch;patch=1 \
           file://vpnc${PV}--long-help \
           file://default.conf"

SRC_URI[md5sum] = "4378f9551d5b077e1770bbe09995afb3"
SRC_URI[sha256sum] = "46cea3bd02f207c62c7c6f2f22133382602baeda1dc320747809e94881414884"
