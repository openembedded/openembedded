DESCRIPTION = "Entrance is the Enlightenment login manager"
LICENSE = "MIT BSD"
# can also use pam and crypt
DEPENDS = "evas ecore edje esmart bash keylaunch xserver-common login-manager"
RDEPENDS_${PN} += "glibc-gconv-iso8859-1 entrance-themes"
PR = "r3"

# entrance and estickies were removed in 46590 for rewrite, move back to EFL_SRCREV when they're back
SRCREV = "46589"

inherit e
SRC_URI = "${E_SVN}/trunk;module=${SRCNAME};proto=http;scmdata=keep"
S = "${WORKDIR}/${SRCNAME}"

SRC_URI += "\
           file://rebased_config-db.patch \
           file://allow-missing-xsession.patch \
           file://run-Xinit.patch \
           file://fix-auth-mode.patch \
           file://use-bash.patch \
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
