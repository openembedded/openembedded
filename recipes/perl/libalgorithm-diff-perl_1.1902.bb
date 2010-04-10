DESCRIPTION = "Algorithm::Diff - Compute intelligent differences between two files / lists"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-exporter perl-module-strict perl-module-vars \
	     perl-module-strict perl-module-vars"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TY/TYEMQ/Algorithm-Diff-${PV}.tar.gz"

S = "${WORKDIR}/Algorithm-Diff-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "ff3e17ae485f8adfb8857b183991fbce"
SRC_URI[sha256sum] = "c8b40dbf406770c6bcbd1a26a3f2343fa1563675085b63932d06f37e60098375"
