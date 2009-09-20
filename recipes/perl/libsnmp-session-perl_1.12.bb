DESCRIPTION = "Perl support for accessing SNMP-aware devices"
SECTION = "libs"
LICENSE = "Artistic"
PR = "r0"

SRC_URI = "http://www.switch.ch/misc/leinen/snmp/perl/dist/SNMP_Session-${PV}.tar.gz"

S = "${WORKDIR}/SNMP_Session-${PV}"

inherit cpan
