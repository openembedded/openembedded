# BROKEN because it needs a native antlr, which in turn needs
# a native java virtual machine.  blech. -CL
BROKEN = "1"
DEPENDS += "antlr-native"

DESCRIPTION = "C and C++ Code Counter, a software metrics tool"
LICENSE = "PD"
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

SRC_URI[md5sum] = "7b3d8bd3cbb27d7b9debe5c3398f9f7f"
SRC_URI[sha256sum] = "015c4237a532b873990aeeecdf351138ce5a811d062d6db73c611a4985de5435"
