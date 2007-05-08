SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r3"

SRC_URI = "http://www.cpan.org/modules/by-module/Mail/Mail-Sendmail-${PV}.tar.gz"

S = "${WORKDIR}/Mail-Sendmail-${PV}"

inherit cpan
