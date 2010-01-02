DESCRIPTION = "ExtUtils::Depends - Easily build XS extensions that depend on XS extensions"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RM/RMCFARLA/Gtk2-Perl/ExtUtils-Depends-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-Depends-${PV}"

inherit cpan

BBCLASSEXTEND="native"
