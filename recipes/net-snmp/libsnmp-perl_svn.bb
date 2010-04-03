DESCRIPTION = "Perl module from net-snmp"
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = "net-snmp"
SRCREV = "17367"
PR = "r2"

SRC_URI = "svn://net-snmp.svn.sourceforge.net/svnroot/net-snmp/trunk;module=net-snmp;proto=https"

S = "${WORKDIR}/net-snmp/perl"

inherit cpan

EXTRA_CPANFLAGS = "-NET-SNMP-CONFIG=${STAGING_BINDIR}/net-snmp-config -NET-SNMP-IN-SOURCE=false"
