DESCRIPTION = "shr-launcher is a home app/launcher for openmoko phones"
HOMEPAGE = "http://code.google.com/p/shr-launcher/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina edbus"

PV = "0.0.1+svnr${SRCPV}"
PR = "r4"

SRC_URI = "svn://shr-launcher.googlecode.com/svn/trunk;module=.;proto=http"

do_configure_prepend() {
  # all links to /usr/share/automake-1.10/
  rm -f ${S}/depcomp ${S}/config.guess ${S}/config.sub ${S}/INSTALL ${S}/install-sh ${S}/missing
  touch ${S}/INSTALL
}

S = "${WORKDIR}"

inherit autotools

do_install_append() {
        install -d "${D}/${datadir}/pixmaps"
        install -m 0644 "${S}/resources/launcher.png" "${D}/${datadir}/pixmaps"
        install -d "${D}/${datadir}/applications"
        install -m 0644 "${S}/resources/launcher.desktop" "${D}/${datadir}/applications"
        install -d "${D}/${datadir}/launcher"
        for ico in "${S}/resources/"*.png; do
                if [ "$(basename $ico)" != "launcher.png" ]; then
                        install -m 0644 $ico "${D}/${datadir}/launcher"
                fi
        done
}

FILES_${PN} += "/usr/share/launcher/* /usr/share/applications/* /usr/share/pixmaps/*"
