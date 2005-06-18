PV = "1.4"
LICENSE = "MIT"
SRC_URI = "file://mythfront.sh"

do_install() {
	install -d ${D}${sysconfdir}/X11/Xinit.d
	install ${WORKDIR}/mythfront.sh ${D}${sysconfdir}/X11/Xinit.d/90mythfront
}

