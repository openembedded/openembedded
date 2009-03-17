DESCRIPTION = "Script to start a passwordless vnc of the current X session"
LICENSE = "MIT"
RDEPENDS = "x11vnc"

do_install() {
	install -d ${D}/${sysconfdir}/X11/Xinit.d
	echo "#!/bin/sh" > ${D}/${sysconfdir}/X11/Xinit.d/02vnc
	echo "x11vnc  -q -bg -display :0 -forever -avahi" >> ${D}/${sysconfdir}/X11/Xinit.d/02vnc
	chmod 0755 ${D}/${sysconfdir}/X11/Xinit.d/02vnc
}

CONFFILES_${PN} += "${sysconfdir}/X11/Xinit.d/02vnc"
PACKAGE_ARCH = "all"

