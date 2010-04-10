DESCRIPTION = "Mail::Sendmail - Simple platform independent mailer"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://www.cpan.org/modules/by-module/Mail/Mail-Sendmail-${PV}.tar.gz"

S = "${WORKDIR}/Mail-Sendmail-${PV}"

inherit cpan

SRC_URI[md5sum] = "038f261afd091d8fad347d6c66d2833d"
SRC_URI[sha256sum] = "8a5eb39d3b9a3a4219c6d6051328c62bd51e9b53723ee5b42cd66e8672e681b9"
