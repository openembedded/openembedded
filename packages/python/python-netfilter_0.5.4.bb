DESCRIPTION = "Python module to manage netfilter rules"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "iptables iptables-utils python-logging python-shell python-subprocess"
SRCNAME = "python-netfilter"

SRC_URI = "http://opensource.bolloretelecom.eu/files/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
