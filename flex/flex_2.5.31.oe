DESCRIPTION = "Flex is a tool for generating programs \
that recognize lexical patterns in text."
HOMEPAGE = "http://www.gnu.org/software/flex/"
LICENSE = "BSD"
SECTION = "devel"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/lex/flex-${PV}.tar.bz2 \
	   file://include.patch;patch=1"

inherit autotools

do_stage () {
	oe_libinstall -a libfl ${STAGING_LIBDIR}
	install -m 0644 FlexLexer.h ${STAGING_INCDIR}/
}
