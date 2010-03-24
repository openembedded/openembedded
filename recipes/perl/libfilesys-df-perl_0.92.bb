DESCRIPTION = "Filesys-Df - Perl extension for filesystem disk space information"
SECTION = "libs"
LICENSE = "Artistic|GPL"
BBCLASSEXTEND = "native"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/I/IG/IGUTHRIE/Filesys-Df-${PV}.tar.gz;name=filesys-df-perl-${PV}"
SRC_URI[filesys-df-perl-0.92.md5sum] = "a8b0aa3e5151a8a6c8b3067625980934"
SRC_URI[filesys-df-perl-0.92.sha256sum] = "fe89cbb427e0e05f1cd97c2dd6d3866ac6b21bc7a85734ede159bdc35479552a"

S = "${WORKDIR}/Filesys-Df-${PV}"

inherit cpan
