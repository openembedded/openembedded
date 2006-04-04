DESCRIPTION = "This tool read out the tics counter of the operating system and \
calculates the Percentages spend in each CPU_STATE."
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www8.in.tum.de/~schneifa/group/sources/cpusage-${PV}.tar.gz \
           file://cpusage.patch;patch=1"

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
