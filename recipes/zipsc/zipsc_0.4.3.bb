DESCRIPTION = "IP/Subnet calculator for Qt/Embedded based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.warmi.net/zaurus/zipsc.shtml"
PR = "r2"

SRC_URI = "http://www.warmi.net/zaurus/files/zipsc_${PV}.tar.gz \
           file://gcc3.patch;patch=1"
S = "${WORKDIR}/zipsc_${PV}"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/bin \
                   ${D}${palmtopdir}/apps/Applications \
                   ${D}${palmtopdir}/pics \
                   ${D}${palmtopdir}/pics/zipsc
        install -m 0755 zipsc ${D}${palmtopdir}/bin/
        install -m 0644 Qtopia/opt/QtPalmtop/pics/zipsc.png ${D}${palmtopdir}/pics/
        install -m 0644 Qtopia/opt/QtPalmtop/pics/zipsc/*.png_ ${D}${palmtopdir}/pics/zipsc/
        install -m 0644 Qtopia/opt/QtPalmtop/apps/Applications/zipsc.desktop ${D}${palmtopdir}/apps/Applications/
}
