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

SRC_URI[md5sum] = "f766680bb237ca2f837c005efba54efa"
SRC_URI[sha256sum] = "fbd907dde45054227568f3117df0418a7819cfee02875d3723779432e8a66dc9"
