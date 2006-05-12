DESCRIPTION = "Entrance is the Enlightenment login manager"
LICENSE = "MIT"
# can also use pam and crypt
DEPENDS = "edb edb-native evas-x11 ecore-x11 edje esmart-x11 bash keylaunch detect-stylus xserver-common"
RDEPENDS += "bash keylaunch detect-stylus xserver-common glibc-gconv-iso8859-1 entrance-themes"
HOMEPAGE = "http://www.enlightenment.org"
PR = "r13"

inherit e update-rc.d

INITSCRIPT_NAME = "entrance"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."

SRC_URI = "${E_URI}/entrance-${PV}.tar.gz \
           file://config-db.patch;patch=1 \
           file://allow-missing-xsession.patch;patch=1 \
           file://run-Xinit.patch;patch=1 \
           file://set-display-env.patch;patch=1 \
           file://fix-auth-mode.patch;patch=1 \
           file://use-bash.patch;patch=1 \
           file://disable-autodetect.patch;patch=1 \
           file://Sessions"

S = "${WORKDIR}/entrance-${PV}"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc \
                --with-xsession=/etc/X11/Xsession \
                --with-auth-mode=0"

FILES_${PN} += "${bindir} ${sbindir} /etc ${datadir}"

do_install_append() {
	install -d ${D}/etc/X11/Xsession.d
	install -d ${D}/etc/X11/Sessions
	
	install -m 755 ${WORKDIR}/Sessions/* ${D}/etc/X11/Sessions
}
