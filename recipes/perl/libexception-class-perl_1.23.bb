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

SRC_URI[md5sum] = "560b42c0cf8b795bdc793459edb7ec13"
SRC_URI[sha256sum] = "9ad5a063bac80f3e77a179c91b7ea4490181640c8c1893292fdc6f2d92f40406"
