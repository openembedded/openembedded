SECTION = "devel"
DESCRIPTION = "Flex is a tool for generating programs that recognize lexical patterns in text."
PR = "r0"
LICENSE = "BSD"

SRC_URI = "ftp://ftp.gnu.org/non-gnu/flex/flex-${PV}.tar.gz"
S = "${WORKDIR}/flex-2.5.4"

inherit native autotools

do_stage () {
	install -m 0755 flex ${STAGING_BINDIR}/flex-2.5.4
}
