DESCRIPTION = "LCD4Linux is a small program that grabs information from the kernel and some subsystems and displays it on an external liquid crystal display."
LICENSE = "GPLv2"

DEPENDS = "libusb-compat ncurses readline virtual/libx11"

PV = "0.10.0+0.10.1-RC2"
PR = "r4"

SRC_URI = "http://ssl.bulix.org/projects/lcd4linux/raw-attachment/wiki/Download/lcd4linux-0.10.1-RC2.tar.gz \
           file://libusb-compat.diff;patch=1 \ 
           file://lcd4linux.init"

S =  "${WORKDIR}/lcd4linux-0.10.1-RC2"


inherit autotools update-rc.d

INITSCRIPT_NAME = "lcd4linux"
CONFFILES_${PN} += "${sysconfdir}/lcd4linux.conf"

do_install_append() {
	install -d ${D}/${sysconfdir}
	install -m 0600 ${S}/lcd4linux.conf.sample  ${D}/${sysconfdir}/lcd4linux.conf
	install -d ${D}/${INIT_D_DIR}
	install -m 0755 ${WORKDIR}/lcd4linux.init ${D}/${INIT_D_DIR}/lcd4linux
}

