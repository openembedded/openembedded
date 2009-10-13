DESCRIPTION = "Interface to secure pseudo ttys"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/IO/IO-Stty-.02.tar.gz"

S = "${WORKDIR}/IO-Stty-.02"

inherit cpan
