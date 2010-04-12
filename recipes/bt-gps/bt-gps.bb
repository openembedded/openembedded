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

SRC_URI[md5sum] = "6e0443d09448a5cfdb1d560cfd699a6b"
SRC_URI[sha256sum] = "ca567348c1f8d904f50fe06de83959dcc5b840e12e336251ab216ca5304e3bf0"
