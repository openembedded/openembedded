DESCRIPTION = "Fan controller for fans attached to parallel port"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
SRC_URI = "http://joshuawise.com/code/softfan/softfan-${PV}.tar.gz"
S = "${WORKDIR}/softfan-${PV}"

FILES_${PN} = "/sbin/softfan"

do_compile() {
         ${CC} ${CFLAGS} ${LDFLAGS} -o softfan softfan.c
}

do_install() {
         install -d ${D}${base_sbindir}
         install -m 0755 softfan ${D}${base_sbindir}/softfan
}

SRC_URI[md5sum] = "e19e8a55c70d9b78f3c5abfa456ebf0c"
SRC_URI[sha256sum] = "d1cf80381378041049c2b5ec25afca56939cce1d7dd8a8d8ab2ac46e210e354d"
