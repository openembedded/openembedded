SECTION = "libs"
LICENSE = "Artistic|GPL"
FILE_PR = "r4"

SRC_URI = "http://www.cpan.org/modules/by-module/Mail/Mail-Sendmail-${PV}.tar.gz"

S = "${WORKDIR}/Mail-Sendmail-${PV}"

inherit cpan
