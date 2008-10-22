DESCRIPTION = "802.1q vlan support program"
RRECOMMENDS = "kernel-module-8021q"
PR = "r0"

S = "${WORKDIR}/vlan/"

SRC_URI = "http://www.candelatech.com/~greear/vlan/vlan.${PV}.tar.gz \
	   "

inherit base

CCFLAGS = "-g -D_GNU_SOURCE -Wall -I${STAGING_INCDIR}"
LDLIBS = ""

do_compile() {
	${CC} ${CCFLAGS} -c vconfig.c
	${CC} ${CCFLAGS} ${LDFLAGS} -o vconfig vconfig.o ${LDLIBS}
}

do_install() {
	install -d "${D}${sbindir}"
	install -m 755 "${S}/vconfig" "${D}${sbindir}/vconfig"
}

