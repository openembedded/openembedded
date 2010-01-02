DESCRIPTION = "Term::ProgressBar - provide a progress meter on a standard terminal"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"
DEPENDS = "libtermreadkey-perl libclass-methodmaker-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/F/FL/FLUFFY/Term-ProgressBar-${PV}.tar.gz"

S = "${WORKDIR}/Term-ProgressBar-${PV}"

inherit cpan

BBCLASSEXTEND="native"
