DESCRIPTION = "Params::Validate - Validate method/function parameters"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r14"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Params-Validate-${PV}.tar.gz"

S = "${WORKDIR}/Params-Validate-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/Params/Validate/* \
                ${PERLLIBDIRS}/Params \
                ${PERLLIBDIRS}/Attribute"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "99f6093ecf15717c1a888bb6040aea43"
SRC_URI[sha256sum] = "cf381182872bedd5f70fdb297863373bdfcac4f10f1b276aa227e9722b258be5"
