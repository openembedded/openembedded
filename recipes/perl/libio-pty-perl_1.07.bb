DESCRIPTION = "Perl module for pseudo tty IO"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/IO/IO-Tty-${PV}.tar.gz"

S = "${WORKDIR}/IO-Tty-${PV}"

inherit cpan
