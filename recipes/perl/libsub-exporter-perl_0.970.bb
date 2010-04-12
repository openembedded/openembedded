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

SRC_URI[md5sum] = "10eaa77a13de4c23640cdd1aaf0f2412"
SRC_URI[sha256sum] = "d95895fc8a8277b3b8ff34e2eaaebfb56bbc044c8bf6522dbb47e2fb714b238c"
