DESCRIPTION = "Term::ProgressBar - provide a progress meter on a standard terminal"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"
DEPENDS = "libtermreadkey-perl libclass-methodmaker-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/F/FL/FLUFFY/Term-ProgressBar-${PV}.tar.gz"

S = "${WORKDIR}/Term-ProgressBar-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "440dfd04fe51a12d314e9adf2445f04a"
SRC_URI[sha256sum] = "2c55c84684a05934d5421707d76c1b6f5f45618a818a10d8dcf607027d93065e"
