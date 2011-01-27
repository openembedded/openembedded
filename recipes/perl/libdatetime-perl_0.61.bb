DESCRIPTION = "DateTime - A date and time object"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS = "libtest-exception-perl-native libdatetime-timezone-perl-native libdatetime-locale-perl-native "
RDEPENDS_${PN} = "libtest-exception-perl libdatetime-timezone-perl libdatetime-locale-perl  \
	perl-module-scalar-util perl-module-pod-man perl-module-time-local"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/DateTime-${PV}.tar.gz"
SRC_URI[md5sum] = "0802efbc53eb11a09d1528223cd52e88"
SRC_URI[sha256sum] = "74b561a73dc060b9be3b03ddeafd93b5995673abe71f4614fe402c3eb51d236f"

S = "${WORKDIR}/DateTime-${PV}"

inherit cpan_build

BBCLASSEXTEND="native"
