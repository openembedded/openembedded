SECTION = "devel"
DESCRIPTION = "Flex is a tool for generating programs that recognize lexical patterns in text."
LICENSE = "BSD"
PR = "r0"

SRC_URI = "ftp://ftp.gnu.org/non-gnu/flex/flex-${PV}.tar.gz"
S = "${WORKDIR}/flex-2.5.4"

inherit native autotools

do_stage () {
	install -m 0755 flex ${STAGING_BINDIR}
	oe_libinstall -a libfl ${STAGING_LIBDIR}
	ln -sf ./flex ${STAGING_BINDIR}/flex++
	ln -sf ./flex ${STAGING_BINDIR}/lex
}
