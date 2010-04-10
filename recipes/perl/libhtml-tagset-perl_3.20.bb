DESCRIPTION = "HTML Tagset bits."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PETDANCE/HTML-Tagset-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Tagset-${PV}"

inherit cpan

BBCLASSEXTEND="native"

PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "d2bfa18fe1904df7f683e96611e87437"
SRC_URI[sha256sum] = "adb17dac9e36cd011f5243881c9739417fd102fce760f8de4e9be4c7131108e2"
