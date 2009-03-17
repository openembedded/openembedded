#SRC_URI = "svn://svn.openwrt.org/openwrt;module=trunk/tools/firmware-utils/src;proto=https"
SRC_URI = ${SOURCEFORGE_MIRROR}/gakusei/openwrt-imagetools-svn-rev7641.tar.bz2
S = "${WORKDIR}/src/"

inherit native

do_compile() {
	${CC} -o trx trx.c
	${CC} -o motorola-bin motorola-bin.c
	${CC} -o addpattern addpattern.c
}

do_stage() {
	install -m 0755 ${S}/trx ${STAGING_BINDIR}
	install -m 0755 ${S}/motorola-bin ${STAGING_BINDIR}
	install -m 0755 ${S}/addpattern ${STAGING_BINDIR}
}
