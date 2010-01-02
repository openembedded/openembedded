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
