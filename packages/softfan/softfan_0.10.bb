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
