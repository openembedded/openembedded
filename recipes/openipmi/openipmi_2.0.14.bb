DESCRIPTION = "OpenIPMI is an effort to create a full-function IPMI system, \
               to allow full access to all IPMI information on a server \
               and to abstract it to a level that will make it easy to use"
HOMEPAGE = "http://openipmi.sourceforge.net"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "popt"

SRC_URI = "${SOURCEFORGE_MIRROR}/openipmi/OpenIPMI-${PV}.tar.gz"

S = "${WORKDIR}/OpenIPMI-${PV}"

inherit autotools
