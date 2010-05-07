DEPENDS += "virtual/libc ppp"
DESCRIPTION = " version of the Layer 2 Tunneling Protocol (L2TP) daemon"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.xelerance.com/software/xl2tpd/"
SECTION = "network"

INC_PR  = "r0"

SRC_URI = "http://www.xelerance.com/software/xl2tpd/xl2tpd-${PV}.tar.gz"

S = "${WORKDIR}/xl2tpd-${PV}"

do_compile () {
	oe_runmake CFLAGS="${CFLAGS} -DLINUX" LDFLAGS="${LDFLAGS}" PREFIX="${prefix}" all
}

do_install () { 
	oe_runmake PREFIX="${D}${prefix}" install

        install -d ${D}${sysconfdir}/init.d
        touch ${D}${sysconfdir}/xl2tpd.conf
        install -m 0755 debian/xl2tpd.init ${D}${sysconfdir}/init.d/xl2tpd
	install -d ${D}${sysconfdir}/default
	install -m 0644 debian/xl2tpd.default ${D}${sysconfdir}/default/xl2tpd
}

CONFFILES_${PN} += "${sysconfdir}/xl2tpd.conf ${sysconfdir}/default/xl2tpd"
