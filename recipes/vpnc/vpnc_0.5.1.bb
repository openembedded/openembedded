require vpnc.inc

PR = "r0"

SRC_URI = "http://www.unix-ag.uni-kl.de/~massar/vpnc/vpnc-${PV}.tar.gz \
           file://makeman.patch;patch=1 \
           file://vpnc${PV}--long-help \
           file://default.conf"

SRC_URI[md5sum] = "7a8e94dbe94f39a4fd89b72e0125f66f"
SRC_URI[sha256sum] = "f63660bd020bbe6a39e8eb67ad60c54d719046c6198a6834371d098947f9a2ed"
