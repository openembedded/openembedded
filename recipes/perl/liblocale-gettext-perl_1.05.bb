DESCRIPTION = "Locale::gettext - message handling functions"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "virtual/libintl"
PR = "r9"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PV/PVANDRY/gettext-${PV}.tar.gz"

S = "${WORKDIR}/gettext-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/Locale/gettext/* \
                ${PERLLIBDIRS}/Locale"
