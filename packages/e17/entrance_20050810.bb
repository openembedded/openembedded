DESCRIPTION = "Entrace is the Enlightenment login manager"
SECTION = "e/apps"
LICENSE = "MIT"
# can also use pam and crypt
DEPENDS = "edb evas-x11 ecore-x11 edje esmart gpe-dm"
RDEPENDS += "bash gpe-dm"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"
PR = "r2"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/entrance \
           file://Xserver.patch;patch=1 \
           file://config-db.patch;patch=1 \
           file://allow-missing-xsession.patch;patch=1 \
           file://run-Xinit.patch;patch=1 \
           file://use-bash.patch;patch=1 \
	   file://Xinit.d \
	   file://Sessions"
	   
S = "${WORKDIR}/entrance"

inherit autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc \
                --with-xsession=/etc/X11/Xsession"

FILES += "${datadir}"

do_install_append() {
	install -d ${D}/etc/X11/Xinit.d
	install -d ${D}/etc/X11/Xsession.d
	install -d ${D}/etc/X11/Sessions
	
	install -m 755 ${WORKDIR}/Xinit.d/* ${D}/etc/X11/Xinit.d
	install -m 755 ${WORKDIR}/Sessions/* ${D}/etc/X11/Sessions
	
}
