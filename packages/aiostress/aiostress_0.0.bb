DESCRIPTION = "Asynchronous I/O stress util"
LICENSE = "GPLv2"
DEPENDS = "libaio"

SRC_URI = "ftp://ftp.suse.com/pub/people/mason/utils/aio-stress.c;md5sum=727e5fc3566837b3ea72f887d048769b"

S = "${WORKDIR}"

do_compile() {

	cd ${S} && ${CC} aio-stress.c -o aio-stress -I${STAGING_INCDIR} -L${STAGING_LIBDIR} -laio -lpthread
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 aio-stress ${D}${bindir}
}
