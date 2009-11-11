DESCRIPTION = "Log::Dispatch - Dispatches messages to one or more outputs"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Log-Dispatch-${PV}.tar.gz"

S = "${WORKDIR}/Log-Dispatch-${PV}"

do_stage() {
	:
}

inherit cpan_build
