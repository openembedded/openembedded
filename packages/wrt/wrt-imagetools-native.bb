SRC_URI = "cvs://anonymous@openwrt.org/openwrt;module=openwrt/target/utils/src;tag=TESTED"
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