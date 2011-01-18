DESCRIPTION = "AM SysInfo"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_sysinfo/"
LICENSE = "BSD"
SECTION = "system"
PRIORITY = "optional"

SRCREV = "6"
PV = "1.0"
PR = "r1+svnr${SRCPV}"

SRC_URI = "svn://gforge.ti.com/svn/am_sysinfo/;module=trunk;proto=https;user=anonymous;pswd=''"

S = "${WORKDIR}/trunk"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o mem_util/mem_util mem_util/mem_util.c
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/mem_util/mem_util ${D}/${bindir}
}
