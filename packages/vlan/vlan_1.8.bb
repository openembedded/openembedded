DESCRIPTION = "802.1q vlan support program"
RRECOMMENDS = "kernel-module-8021q"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
PR = "r2"

S = "${WORKDIR}/vlan/"

SRC_URI = "http://scry.wanfear.com/~greear/vlan/vlan.1.8.tar.gz \
	   "

inherit base

CCFLAGS = "-g -D_GNU_SOURCE -Wall -I${STAGING_INCDIR}"
LDLIBS = ""

do_compile() {
	${CC} ${CCFLAGS} -c vconfig.c
	${CC} ${CCFLAGS} ${LDFLAGS} -o vconfig vconfig.o ${LDLIBS}
	${STRIP} vconfig
}

do_install() {
	install -d "${D}/usr/sbin"
	install -m 755 "${S}/vconfig" "${D}/usr/sbin/vconfig"
}

