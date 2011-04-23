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

SRC_URI[md5sum] = "7f35543286911b827dcbf8d07a7d72be"
SRC_URI[sha256sum] = "bad49b59646dbea380cc88be13a77d17c70488b8e11e85f7dd474930fa9cf36a"
