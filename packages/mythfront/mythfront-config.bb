PV = "1.7"
PR = "r1"

DEPENDS = "xfonts-xorg"
RDEPENDS_${PN} = "xfonts-xorg"
LICENSE = "MIT"
SRC_URI = "file://tftp.sh file://xorg.conf"

SRC_URI_append_epia = " file://serial.sh"

do_install() {
	install -d ${D}${sysconfdir}/udhcpc.d/
	install ${WORKDIR}/tftp.sh ${D}${sysconfdir}/udhcpc.d/80tftp

	install -d ${D}${sysconfdir}/mythtv
	ln -sf /var/lib/config/mysql.txt ${D}${sysconfdir}/mythtv

	install -d ${D}${sysconfdir}/X11
	install -m 0644 ${WORKDIR}/xorg.conf ${D}${sysconfdir}/X11

	ln -sf /var/lib/config/lircd.conf ${D}${sysconfdir}/lircd.conf

	install -d ${D}/dev
	ln -sf lirc0 ${D}/dev/lirc

	if [ -f ${WORKDIR}/serial.sh ]; then
		install -d ${D}${sysconfdir}/init.d
		install -d ${D}${sysconfdir}/rc2.d
		install ${WORKDIR}/serial.sh ${D}${sysconfdir}/init.d/mythfront-serial
		ln -sf ../init.d/mythfront-serial ${D}${sysconfdir}/rc2.d/S10mythfront-serial
	fi
}

