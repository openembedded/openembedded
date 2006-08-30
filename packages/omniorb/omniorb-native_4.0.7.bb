PR = "r0"
SRC_URI = "${SOURCEFORGE_MIRROR}/omniorb/omniORB-${PV}.tar.gz"
SECTION = "devel"
S = "${WORKDIR}/omniORB-${PV}"

DEPENDS += python-native

inherit native autotools

do_compile () {
	oe_runmake
}


#do_stage() {
#	install -m 0755 src/bison ${STAGING_BINDIR}/
#	ln -sf ./bison ${STAGING_BINDIR}/yacc
#	install -d ${STAGING_BINDIR}/../share/bison/m4sugar
#	install -m 0755 data/c.m4 data/glr.c data/lalr1.cc data/yacc.c ${STAGING_BINDIR}/../share/bison/
#	install -m 0755 data/m4sugar/m4sugar.m4 ${STAGING_BINDIR}/../share/bison/m4sugar/
#}
