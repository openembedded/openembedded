DESCRIPTION = "Algorithm::Diff - Compute intelligent differences between two files / lists"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-exporter perl-module-strict perl-module-vars \
	    "perl-module-exporter perl-module-strict perl-module-vars"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TY/TYEMQ/Algorithm-Diff-${PV}.tar.gz"

S = "${WORKDIR}/Algorithm-Diff-${PV}"

inherit cpan
