DEPENDS = ""
DESCRIPTION = "Highly configurable, modular and secure inetd"
PR ="r0"

SRC_URI = "http://www.xinetd.org/xinetd-${PV}.tar.gz \
	  file://configure.patch \
	  file://xinetd.init \
	  file://xinetd.conf \
	  "
SRC_URI[md5sum] = "567382d7972613090215c6c54f9b82d9"
SRC_URI[sha256sum] = "760e0e617c609a0509ef63fc7e9580d2f1d88c6113bb6d63273de7de7cd0bc1f"

EXTRA_OECONF="--disable-nls"

inherit autotools update-rc.d

INITSCRIPT_NAME = "xinetd"
INITSCRIPT_PARAMS = "defaults"

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
