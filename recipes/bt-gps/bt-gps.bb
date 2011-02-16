DESCRIPTION = "Turns your Neo Freerunner into a bluetooth GPS"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv3+"
RDEPENDS_${PN} = "python python-pygtk gps-utils"
PR = "r2"

SRC_URI = "http://handheldshell.com/software/fso/btgps.tgz"
SRC_URI[md5sum] = "6e0443d09448a5cfdb1d560cfd699a6b"
SRC_URI[sha256sum] = "ca567348c1f8d904f50fe06de83959dcc5b840e12e336251ab216ca5304e3bf0"

S = ${WORKDIR}/bluetooth

do_install() {
        install -d ${D}${datadir}/applications
        install -d ${D}${bindir}
        install -m 0755 ${S}/BtGPS.py ${D}${bindir}
        install -m 0755 ${S}/btgps.desktop ${D}${datadir}/applications
}

do_configure() {
        exit 0
}

do_compile() {
        # fix hardcoded path
        sed -i "s#/usr/bin/python#env python#g" BtGPS.py
        sed -i "s#/usr/bin/sdptool#${bindir}/sdptool#g" BtGPS.py
        # fix QA issues
        sed -i "s/Categories=GTK;Application;PIM/Categories=Utility;/g" btgps.desktop
        sed -i "s/Comment=BT GPS/Comment=Turns your Neo Freerunner into a bluetooth GPS/g" btgps.desktop
        sed -i "/^Encoding/d; /^SingleInstance/d; /^Categories=Office;/d" btgps.desktop
}
