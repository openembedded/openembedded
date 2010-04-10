DESCRIPTION = "This tool read out the tics counter of the operating system and \
calculates the Percentages spend in each CPU_STATE."
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www8.in.tum.de/~schneifa/group/sources/cpusage-${PV}.tar.gz"

S = "${WORKDIR}/cpusage-${PV}"

FILES_${PN} = "/sbin/cpusage"

CFLAGS_append =" -D_BSD_SOURCE=1"
CFLAGS_append = '${@base_conditional("KERNEL_MAJOR_VERSION", "2.6", " -D__Linux26__ ", " -D__Linux24__ ",d)}'


do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o cpusage cpusage.c
}

do_install() {
	install -d ${D}${base_sbindir}
	install -m 0755 cpusage ${D}${base_sbindir}/cpusage
}

SRC_URI[md5sum] = "4f2662346fa8e6feeebceafc4ec18090"
SRC_URI[sha256sum] = "f301bca2f5999cd16fec01db58d0fbba781eb659ce30d532cc9569e7950b90bf"
