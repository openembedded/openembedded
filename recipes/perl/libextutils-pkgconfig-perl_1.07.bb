DESCRIPTION = "ExtUtils::PkgConfig - simplistic interface to pkg-config"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RM/RMCFARLA/Gtk2-Perl/ExtUtils-PkgConfig-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-PkgConfig-${PV}"

inherit cpan

BBCLASSEXTEND="native"
