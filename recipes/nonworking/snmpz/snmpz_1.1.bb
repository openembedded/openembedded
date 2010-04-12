DESCRIPTION = "A MIB Browser for Opie/Qtopia"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe snmp++"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/SNMPz-${PV}.tar.gz"
S = "${WORKDIR}/SNMPz-${PV}"


SRC_URI[md5sum] = "de9c5591ef61498055779af0f0a445f3"
SRC_URI[sha256sum] = "ede9e8aa1d56e50a18a9c3ad3778e24c9612128739bbab9112278367289b81ea"
