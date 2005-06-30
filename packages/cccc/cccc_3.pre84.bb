# BROKEN because it needs a native antlr, which in turn needs
# a native java virtual machine.  blech. -CL
BROKEN = "1"
DEPENDS += "antlr-native"

DESCRIPTION = "C and C++ Code Counter, a software metrics tool"
LICENSE = "PD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "optional"
SECTION = "devel"
HOMEPAGE = "http://cccc.sourceforge.net/"

SRC_URI = "${SOURCEFORGE_MIRROR}/cccc/cccc-${PV}.tar.gz"

EXTRA_OEMAKE = "'CCC=${CC}' 'LD=${CC}' \
		'CFLAGS=-c -I${S}/pccts/h -x c++ ${CFLAGS}' \
		'LDFLAGS=${LDFLAGS}'"

do_compile () {
	oe_runmake -C cccc -f posixgcc.mak
}
