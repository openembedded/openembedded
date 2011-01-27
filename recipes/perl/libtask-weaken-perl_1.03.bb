DESCRIPTION = "Task::Weaken - Ensure that a platform has weaken support"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADAMK/Task-Weaken-${PV}.tar.gz"
SRC_URI[md5sum] = "056ce36c576450d22e6b23b4dbfacd02"
SRC_URI[sha256sum] = "fb1de84c81c523147f4007c559d3ac38fa474b2999f68b14387bb67e061ca8d0"

S = "${WORKDIR}/Task-Weaken-${PV}"

inherit cpan

BBCLASSEXTEND="native"
