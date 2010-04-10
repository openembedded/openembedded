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

SRC_URI[md5sum] = "0ee07cbdfe8c5f838f653c0fb7328c4d"
SRC_URI[sha256sum] = "fa1b97a6d9d2f7d7699f6b0ccd433ab132c7d10835b449ed14b12b48e7749aad"
