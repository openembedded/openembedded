DESCRIPTION = "Firmware for the Prism3 cards"
SECTION = "base"
LICENSE = "Unknown"
PR = "r2"

SRC_URI = "http://www.red-bean.com/~proski/firmware/${PV}.tar.gz \
	   http://www.red-bean.com/~proski/firmware/primary.tar.gz"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/pcmcia/
	install -m 0644 primary/pm010102.hex ${D}${sysconfdir}/pcmcia/
	install -m 0644 1.8.3/rf010803.hex ${D}${sysconfdir}/pcmcia/
	cat >${D}${sysconfdir}/pcmcia/README.prism3-firmware <<EOF
To make a prism3 card w/ downloadable firmware work, do the following:
	0.) Install hostap-utils
	1.) Add "needs_reset yes" and "needs_firmware hostap_fw_load" to
	    the proper interface in /etc/network/interfaces
	2.) echo -e "#!/bin/sh\nifdown wlan0" >> /etc/apm/suspend.d/ifdown
	3.) chmod a+rx /etc/apm/suspend.d/ifdown
	4.) echo -e "#!/bin/sh\nifup wlan0" >> /etc/apm/resume.d/ifup
	5.) chmod a+rx /etc/apm/suspend.d/ifup
EOF
}
