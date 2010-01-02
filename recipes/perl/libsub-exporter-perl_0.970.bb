DESCRIPTION = "Sub::Exporter - a sophisticated exporter for custom-built routines"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libdata-optlist-perl-native libsub-install-perl-native \
            libparams-util-perl-native"
RDEPENDS += "perl-module-carp libdata-optlist-perl libparams-util-perl \
             perl-module-strict libsub-install-perl perl-module-warnings"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Sub-Exporter-${PV}.tar.gz"

S = "${WORKDIR}/Sub-Exporter-${PV}"

inherit cpan

BBCLASSEXTEND="native"
