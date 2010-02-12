DESCRIPTION = "Entrance is the Enlightenment login manager"
LICENSE = "MIT BSD"
# can also use pam and crypt
DEPENDS = "evas ecore edje esmart bash keylaunch xserver-common login-manager"
RDEPENDS += "glibc-gconv-iso8859-1 entrance-themes"
PR = "r2"

inherit e

SRC_URI += "\
           file://rebased_config-db.patch;patch=1 \
           file://allow-missing-xsession.patch;patch=1 \
           file://run-Xinit.patch;patch=1 \
           file://fix-auth-mode.patch;patch=1 \
           file://use-bash.patch;patch=1 \
           file://Sessions"

S = "${WORKDIR}/entrance"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
                --with-xsession=/etc/X11/Xsession \
                --with-auth-mode=0"

FILES_${PN}-dbg += "${libexecdir}/entrance/.debug/*"

do_configure_prepend() {
	autopoint
}

do_install_append() {
	install -d ${D}/etc/X11/Xsession.d
	install -d ${D}/etc/X11/Sessions

	install -m 755 ${WORKDIR}/Sessions/* ${D}/etc/X11/Sessions

	install -d ${D}/etc/X11/login-managers/
	mv ${D}/etc/init.d/entrance ${D}/etc/X11/login-managers/entrance
}
