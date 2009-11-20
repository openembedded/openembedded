DESCRIPTION = "Turns your Neo Freerunner into a bluetooth GPS"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-pygtk gps-utils"

SRC_URI = "http://handheldshell.com/software/fso/btgps.tgz  \
	  "

#inherit autotools

S = ${WORKDIR}/bluetooth

do_install() {
        install -d ${D}/usr/share/applications
        install -d ${D}/usr/bin
        install -m 0755 ${S}/BtGPS.py ${D}/usr/bin
        install -m 0755 ${S}/btgps.desktop ${D}/usr/share/applications
}

do_configure() {
        exit 0
}

do_compile() {
        exit 0
}
