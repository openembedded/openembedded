DESCRIPTION = "Params::Validate - Validate method/function parameters"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Params-Validate-${PV}.tar.gz"

S = "${WORKDIR}/Params-Validate-${PV}"

inherit cpan_build

FILES_${PN} = "${PERLLIBDIRS}/auto/Params/Validate/* \
                ${PERLLIBDIRS}/Params \
                ${PERLLIBDIRS}/Attribute"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "f544f12357ae4ba44044cd8cb2b83a9f"
SRC_URI[sha256sum] = "0739ccd0e7c7c0ffc0e2ad797d78e42c050e6297ab58d56f90a0e4de623f8942"
