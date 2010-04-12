DESCRIPTION = "Perl module from net-snmp"
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = "net-snmp"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz"

S = "${WORKDIR}/net-snmp-${PV}/perl"

inherit cpan

EXTRA_CPANFLAGS = "-NET-SNMP-CONFIG=\"sh ${STAGING_BINDIR}/net-snmp-config\""

SRC_URI[md5sum] = "984932520143f0c8bf7b7ce1fc9e1da1"
SRC_URI[sha256sum] = "11a8baf167f7bfff60d2590e050991400a3a082923dbcdbf85e0e0ce46eb247c"
