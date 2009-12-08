DESCRIPTION = "e-tasks is a todo program for Openmoko phones"
HOMEPAGE = "http://code.google.com/p/e-tasks/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary eina edbus sqlite3"

inherit autotools

PV = "0.0.1+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://e-tasks.googlecode.com/svn/trunk;module=.;proto=http"
S = "${WORKDIR}"

do_configure_prepend() {
  rm -f ${S}/config.log
  rm -f ${S}/config.status
}

do_install_append() {
        install -d "${D}/${datadir}/pixmaps"
        install -m 0644 "${S}/resources/e-tasks.png" "${D}/${datadir}/pixmaps"
        install -d "${D}/${datadir}/applications"
        install -m 0644 "${S}/resources/e-tasks.desktop" "${D}/${datadir}/applications"
        install -d  "${D}/${datadir}/e-tasks"
        for ico in "${S}/resources/"*.png; do
                if [ "$(basename $ico)" != "e-tasks.png" ]; then
                        install -m 0644 $ico "${D}/${datadir}/e-tasks"
                fi
        done
}

FILES_${PN} += "/usr/share/e-tasks/* /usr/share/applications/* /usr/share/pixmaps/*"
