DESCRIPTION = "libwww-perl provides a simple and consistent API to the World Wide Web"
SECTION = "libs"
LICENSE = "Artistic"
DEPENDS = "liburi-perl-native"
RDEPENDS = "liburi-perl"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/libwww-perl-${PV}.tar.gz"

S = "${WORKDIR}/libwww-perl-${PV}"

inherit cpan

do_configure_append() {
    sed -i -e "s|PERL_ARCHLIB = /usr/lib/perl/5.8|PERL_ARCHLIB = ${STAGING_LIBDIR_NATIVE}/perl/5.8.8|" Makefile
}

BBCLASSEXTEND="native"
