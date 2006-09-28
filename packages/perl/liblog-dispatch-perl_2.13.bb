DESCRIPTION = "Log::Dispatch - Dispatches messages to one or more outputs"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS = "libmodule-build-perl-native"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Log-Dispatch-2.13.tar.gz"

S = "${WORKDIR}/Log-Dispatch-${PV}"

inherit cpan_build
