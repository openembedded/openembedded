DESCRIPTION = "Entrace is the Enlightenment login manager"
SECTION = "e/apps"
LICENSE = "MIT"
# can also use pam and crypt
DEPENDS = "edb evas-x11 ecore-x11 edje esmart"
RDEPENDS += "bash"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"
PR = "r0"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/entrance \
           file://longer-sleep.patch;patch=1 \
           file://Xserver.patch;patch=1 \
           file://config-db.patch;patch=1 \
           file://allow-missing-xsession.patch;patch=1"
S = "${WORKDIR}/entrance"

inherit autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc \
                --with-xsession=/etc/X11/Xsession"

FILES += "${datadir}"