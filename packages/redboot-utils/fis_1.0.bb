DESCRIPTION = "Tool to edit the Redboot FIS partition layout from userspace"
PR = "r3"

SRC_URI = "http://svn.chezphil.org/utils/trunk/fis.c"

do_compile() {
	${CC} --std=c99 -Os -W -o fis ${WORKDIR}/fis.c
}

do_install() {
	${STRIP} ${WORKDIR}/fis-${PV}/fis

	install -d ${D}/${sbindir}
	install -m 755 ${WORKDIR}/fis-${PV}/fis ${D}/${sbindir}
}
