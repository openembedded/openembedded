DESCRIPTION = "Entrance is the Enlightenment login manager"
SECTION = "e/apps"
LICENSE = "MIT"
# can also use pam and crypt
DEPENDS = "edb edb-native evas-x11 ecore-x11 edje esmart-x11 bash keylaunch detect-stylus xserver-common login-manager"
RDEPENDS += "bash keylaunch detect-stylus xserver-common glibc-gconv-iso8859-1 login-manager"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r13"

SRC_URI = "http://enlightenment.freedesktop.org/files/entrance-${PV}.tar.gz \
           file://config-db.patch;patch=1 \
           file://allow-missing-xsession.patch;patch=1 \
           file://run-Xinit.patch;patch=1 \
           file://set-display-env.patch;patch=1 \
           file://fix-auth-mode.patch;patch=1 \
           file://use-bash.patch;patch=1 \
	   file://Sessions"

S = "${WORKDIR}/entrance-${PV}"

inherit autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc \
                --with-xsession=/etc/X11/Xsession \
                --with-auth-mode=0"

FILES += "${datadir}"

do_install_append() {
	install -d ${D}/etc/X11/Xsession.d
	install -d ${D}/etc/X11/Sessions
	
	install -m 755 ${WORKDIR}/Sessions/* ${D}/etc/X11/Sessions

	install -d ${D}/etc/X11/login-managers/
	mv ${D}/etc/init.d/entrance ${D}/etc/X11/login-managers/entrance	
}
