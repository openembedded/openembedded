DESCRIPTION = "The database interface driver for the MySQL database."
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
INC_PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/C/CA/CAPTTOFU/DBD-mysql-${PV}.tar.gz"

S = "${WORKDIR}/DBD-mysql-${PV}"

inherit cpan
