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

SRC_URI[md5sum] = "88349394af92f521e1ccc845d64fb9f2"
SRC_URI[sha256sum] = "ab8fdcfdbb6c74ecef4cfaf9e83f955aa422e43f8cd8683c1f2648c70070b88c"
