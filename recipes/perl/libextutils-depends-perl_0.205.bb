DESCRIPTION = "ExtUtils::Depends - Easily build XS extensions that depend on XS extensions"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RM/RMCFARLA/Gtk2-Perl/ExtUtils-Depends-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-Depends-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "02c22a93ec9efb8e457764114ce24eb4"
SRC_URI[sha256sum] = "e098bfb3a50b0629434011a9b56314c9045c09fac7e5d06bf57d43ffd53c1918"
