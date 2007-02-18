DESCRIPTION = "A MIB Browser for Opie/Qtopia"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe snmp++"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/SNMPz-${PV}.tar.gz"
S = "${WORKDIR}/SNMPz-${PV}"

