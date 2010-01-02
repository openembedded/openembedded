DESCRIPTION = "Exception::Class - A module that allows you to declare real exception classes in Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libclass-data-inheritable-perl-native libdevel-stacktrace-perl-native"
RDEPENDS = "libclass-data-inheritable-perl libdevel-stacktrace-perl"
PR = "r8"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Exception-Class-${PV}.tar.gz"

S = "${WORKDIR}/Exception-Class-${PV}"

inherit cpan

BBCLASSEXTEND="native"
