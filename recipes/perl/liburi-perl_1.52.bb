DESCRIPTION = "Manipulates and accesses URI strings"
SECTION = "libs"
LICENSE = "Artistic|GPL"
#RDEPENDS += " libmime-base64-perl libnet-perl"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/URI-${PV}.tar.gz"

S = "${WORKDIR}/URI-${PV}"

inherit cpan

BBCLASSEXTEND="native"

do_configure_append() {
    sed -i -e "s|PERL_ARCHLIB = /usr/lib/perl/5.8|PERL_ARCHLIB = ${STAGING_LIBDIR_NATIVE}/perl/5.8.8|" Makefile
}
