DESCRIPTION = "The database interface driver for the MySQL database."
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/C/CA/CAPTTOFU/DBD-mysql-${PV}.tar.gz"

S = "${WORKDIR}/DBD-mysql-${PV}"

inherit cpan
