DESCRIPTION = "Interface to secure pseudo ttys"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/IO/IO-Stty-.02.tar.gz"

S = "${WORKDIR}/IO-Stty-.02"

inherit cpan

SRC_URI[md5sum] = "db2919cf267fce93682f0f854359f04e"
SRC_URI[sha256sum] = "5095bfac4c610e9e83b31a313c0e3a4a1280bbf39f17a274f5f25dfd8caf2b83"
