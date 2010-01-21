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
