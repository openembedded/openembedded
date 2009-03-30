DESCRIPTION = "Asynchronous I/O stress util"

SRC_URI = "http://www.codemonkey.org.uk/projects/fsx/fsx-linux.c"

S = "${WORKDIR}"

do_compile() {

	cd ${S} && ${CC} fsx-linux.c -o fsx-linux -I${STAGING_INCDIR} -L${STAGING_LIBDIR}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 fsx-linux ${D}${bindir}
}
