DESCRIPTION = "Examines and sets the MII registers of network cards."
LICENSE = "GPL"
SECTION = "console/network"
PRIORITY = "optional"
PR = "r4"

S = "${WORKDIR}/"

#PACKAGE_STRIP = "no"

SRC_URI = "file://mii-diag.c \
           file://libmii.c"

FILES_${PN} = "${base_sbindir}/mii-diag"

do_compile() {
${CC} -O -c libmii.c
${CC} -O -DLIBMII mii-diag.c libmii.o -o mii-diag ${LDFLAGS}
}

do_install() {
	install -d ${D}/${base_sbindir}
	install -m 0755 ${S}/mii-diag ${D}/${base_sbindir}/
}
