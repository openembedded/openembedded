SECTION = "devel"
DESCRIPTION = "Flex is a tool for generating programs that recognize lexical patterns in text."
LICENSE = "BSD"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lex/flex-${PV}.tar.bz2"
S = "${WORKDIR}/flex-${PV}"

inherit native autotools

do_stage () {
	install -m 0755 flex ${STAGING_BINDIR}
	oe_libinstall -a libfl ${STAGING_LIBDIR}
	ln -sf ./flex ${STAGING_BINDIR}/flex++
	ln -sf ./flex ${STAGING_BINDIR}/lex
}
