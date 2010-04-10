DESCRIPTION = "Python module to manage netfilter rules"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "iptables iptables-utils python-logging python-shell python-subprocess"
SRCNAME = "python-netfilter"
PR = "ml0"

SRC_URI = "http://opensource.bolloretelecom.eu/files/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "058983355c399407be999d4e8c16cbe6"
SRC_URI[sha256sum] = "bce93266c593d79d7083052a6cae516de3d6c3e5bda277f664785d30157b8ac7"
