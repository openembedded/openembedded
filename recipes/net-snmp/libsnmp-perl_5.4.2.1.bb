DESCRIPTION = "Perl module from net-snmp"
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = "net-snmp"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz"

S = "${WORKDIR}/net-snmp-${PV}/perl"

inherit cpan

EXTRA_CPANFLAGS = "-NET-SNMP-CONFIG=\"sh ${STAGING_BINDIR}/net-snmp-config\""
