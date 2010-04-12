DEPENDS = ""
DESCRIPTION = "Highly configurable, modular and secure inetd"
PR ="r4"

SRC_URI = "http://www.xinetd.org/xinetd-${PV}.tar.gz \
	  file://xinetd.init \
	  file://xinetd.conf \
	  file://service.c.patch;patch=1 \
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

SRC_URI[md5sum] = "4295b5fe12350f09b5892b363348ac8b"
SRC_URI[sha256sum] = "eddfd1bf3684eaff3a7ba424421d3126878a7469ced0f3d370c7cf66bde64522"
