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

SRC_URI[md5sum] = "727e5fc3566837b3ea72f887d048769b"
SRC_URI[sha256sum] = "3f32e5a1ef0ae84794cfdf7d60bd595a2b3c3995bb91bf79c2b96eb6be7e5529"
