DESCRIPTION = "Exception::Class - A module that allows you to declare real exception classes in Perl"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS = "libclass-data-inheritable-perl-native libdevel-stacktrace-perl-native"
RDEPENDS = "libclass-data-inheritable-perl libdevel-stacktrace-perl"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Exception-Class-1.23.tar.gz"

S = "${WORKDIR}/Exception-Class-${PV}"

inherit cpan
