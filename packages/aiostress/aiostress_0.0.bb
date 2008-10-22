DESCRIPTION = "Asynchronous I/O stress util"
LICENSE = "GPLv2"
DEPENDS = "libaio"
PR ="r1"

SRC_URI = "http://mirrors.easynews.com/linux/suse/people/mason/utils/aio-stress.c"

S = "${WORKDIR}"

do_compile() {

	cd ${S} && ${CC} aio-stress.c -o aio-stress -I${STAGING_INCDIR} -L${STAGING_LIBDIR} -laio -lpthread
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 aio-stress ${D}${bindir}
}
