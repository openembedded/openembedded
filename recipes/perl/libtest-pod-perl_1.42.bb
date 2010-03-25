DESCRIPTION = "Test::Pod - check for POD errors in files"
SECTION = "libs"
LICENSE = "Artistic|GPL"
BBCLASSEXTEND = "native"
RDEPENDS_${PN} += "perl-module-test-more perl-module-file-spec perl-module-module-build perl-module-pod-simple"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DW/DWHEELER/Test-Pod-${PV}.tar.gz;name=test-pod-perl-${PV}"
SRC_URI[test-pod-perl-1.42.md5sum] = "9c9b7ff52ea339aecbf247cd573df238"
SRC_URI[test-pod-perl-1.42.sha256sum] = "ea6de469a8db6549381e41095055bc3741aadf0d353aa1bd5b6e441bc500a79c"

S = "${WORKDIR}/Test-Pod-${PV}"

inherit cpan_build

PACKAGE_ARCH = "all"
