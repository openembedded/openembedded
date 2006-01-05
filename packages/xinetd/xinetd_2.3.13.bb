DEPENDS = ""
DESCRIPTION = "Highly configurable, modular and secure inetd"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
PR="r3"

SRC_URI = "http://www.xinetd.org/xinetd-${PV}.tar.gz \
	  file://xinetd.init \
	  file://xinetd.conf \
	  "

EXTRA_OECONF="--disable-nls"

inherit autotools update-rc.d

INITSCRIPT_NAME = "xinetd"
INITSCRIPT_PARAMS = "defaults"

do_configure() {
	# Looks like configure.in is broken, so we are skipping
	# rebuilding configure and are just using the shipped one
	oe_runconf
}

INHIBIT_AUTO_STAGE = "1"

do_install() {
	# Same here, the Makefile does some really stupid things,
	# but since we only want two files why not override
	# do_install from autotools and doing it ourselfs?
	install -d "${D}/usr/sbin"
	install -d "${D}/etc/init.d"
	install -d "${D}/etc/xinetd.d"
	install -m 644 "${WORKDIR}/xinetd.conf" "${D}/etc"
	install -m 755 "${WORKDIR}/xinetd.init" "${D}/etc/init.d/xinetd"
	install -m 755 "${S}/xinetd/xinetd" "${D}/usr/sbin"
	install -m 755 "${S}/xinetd/itox" "${D}/usr/sbin"

}

CONFFILES_${PN} = "${sysconfdir}/xinetd.conf"
