include util-linux.inc

PR = "r0"

inherit native

PACKAGES = ""
RRECCOMMENDS_${PN} = ""
RDEPENDS_${PN} = ""

S="${WORKDIR}/util-linux-${PV}"

EXTRA_OEMAKE="'OPT=${BUILD_CFLAGS}' 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'LDFLAGS=${BUILD_LDFLAGS}' SBINDIR=${base_sbindir} USRSBINDIR=${base_sbindir} LOGDIR=${localstatedir}/log VARPATH=${localstatedir} LOCALEDIR=${datadir}/locale"

do_compile () {
	set -e
	install ${WORKDIR}/MCONFIG ${S}/MCONFIG
	install ${WORKDIR}/make_include ${S}/make_include
	install ${WORKDIR}/swapargs.h ${S}/mount/swapargs.h
	install ${WORKDIR}/defines.h ${S}/defines.h
	oe_runmake 
}

do_stage () {
	autotools_stage_all
}

do_install () {
	:
}
