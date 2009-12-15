DESCRIPTION = "guitar tuner for openmoko phones"
HOMEPAGE = "http://code.google.com/p/guitartune"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "gtk+ libglade fftw sqlite3"

PV = "0.36+svnr${SRCPV}"

SRC_URI = "svn://guitartune.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit autotools

do_install_append() {
        install -d "${D}/${datadir}/pixmaps"
        install -m 0644 "${S}/resources/guitartune.png" "${D}/${datadir}/pixmaps"
        install -d "${D}/${datadir}/applications"
        install -m 0644 "${S}/resources/guitartune.desktop" "${D}/${datadir}/applications"
        install -d "${D}/${datadir}/guitartune"
        for ico in "${S}/resources/"*.png; do
                if [ "$(basename $ico)" != "guitartune.png" ]; then
                        install -m 0644 $ico "${D}/${datadir}/guitartune"
                fi
        done
}

FILES_${PN} += "/usr/share/guitartune/* /usr/share/applications/* /usr/share/pixmaps/*"
