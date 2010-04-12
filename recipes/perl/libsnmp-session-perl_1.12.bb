DESCRIPTION = "Perl support for accessing SNMP-aware devices"
SECTION = "libs"
LICENSE = "Artistic"
PR = "r0"

SRC_URI = "http://www.switch.ch/misc/leinen/snmp/perl/dist/SNMP_Session-${PV}.tar.gz"

S = "${WORKDIR}/SNMP_Session-${PV}"

inherit cpan

SRC_URI[md5sum] = "5f6b365b4c3815b13d7a902d94e254af"
SRC_URI[sha256sum] = "957053683ca36129565db5018dd219bcc740ae781c4fbc9bc03f263f691730e8"
