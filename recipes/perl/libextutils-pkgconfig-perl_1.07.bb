DESCRIPTION = "ExtUtils::PkgConfig - simplistic interface to pkg-config"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RM/RMCFARLA/Gtk2-Perl/ExtUtils-PkgConfig-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-PkgConfig-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "a8cf945d09c6458cb27228218e9a2f45"
SRC_URI[sha256sum] = "8416e162d6fc921f14a61c8905e9f9a28dc25e67e1c71b75574360a13f0c28c7"
