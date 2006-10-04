DESCRIPTION = "Locale::gettext - message handling functions"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS = "virtual/libintl"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PV/PVANDRY/gettext-${PV}.tar.gz"

S = "${WORKDIR}/gettext-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/Locale/gettext/* \
                ${libdir}/perl5/*/*/auto/Locale/gettext/.packlist \
                ${libdir}/perl5/*/*/Locale"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/Locale/gettext/.debug"
