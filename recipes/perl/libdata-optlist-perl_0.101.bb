DESCRIPTION = "Data::OptList - parse and validate simple name/value option pairs"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libsub-install-perl-native libparams-util-perl-native"
RDEPENDS += "perl-module-list-util libparams-util-perl perl-module-strict \
             libsub-install-perl perl-module-warnings "
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Data-OptList-${PV}.tar.gz"

S = "${WORKDIR}/Data-OptList-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "6e9bb994a8716112a78c1306261f4164"
SRC_URI[sha256sum] = "a96fb122261fb5f069341d7e69dcf07a2988da7cfd8df65d50843b8b102fb55c"
