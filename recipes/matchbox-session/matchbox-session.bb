DESCRIPTION = "Matchbox session support"
RDEPENDS = "matchbox-common"
# they do the same in other way
RCONFLICTS = "gpe-session-scripts"

do_install() {
        install -d ${D}${sysconfdir}/X11/Xsession.d/
        ln -sf ${bindir}/matchbox-session ${D}${sysconfdir}/X11/Xsession.d/90matchbox-session
}

PACKAGE_ARCH = "all"
PACKAGES = "${PN}"

FILES_${PN} = "${sysconfdir}"
