DESCRIPTION = "802.1q vlan support program"
RRECOMMENDS = "kernel-module-8021q"
PR = "r0"

S = "${WORKDIR}/vlan/"

SRC_URI = " \
	http://www.candelatech.com/~greear/vlan/vlan.${PV}.tar.gz \
	file://ip \
	file://vlan-pre-up \
	file://vlan-post-down \
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
	install -d ${D}/${sysconfdir}/network/if-pre-up.d
	install -d ${D}/${sysconfdir}/network/if-post-down.d
	install -d ${D}/${sysconfdir}/network/if-up.d
	install -m 0755 ${WORKDIR}/ip ${D}/${sysconfdir}/network/if-up.d/
	install -m 0755 ${WORKDIR}/vlan-pre-up ${D}/${sysconfdir}/network/if-pre-up.d/vlan
	install -m 0755 ${WORKDIR}/vlan-post-down ${D}/${sysconfdir}/network/if-post-down.d/vlan
}


SRC_URI[md5sum] = "5f0c6060b33956fb16e11a15467dd394"
SRC_URI[sha256sum] = "3b8f0a1bf0d3642764e5f646e1f3bbc8b1eeec474a77392d9aeb4868842b4cca"
