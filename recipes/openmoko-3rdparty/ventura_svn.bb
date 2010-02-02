DESCRIPTION = "ventura is a web browser for openmoko phones"
HOMEPAGE = "http://code.google.com/p/elm-browser/"
AUTHOR = "cchandel"
LICENSE = "GPLv2"
SECTION = "e/apps"
DEPENDS = "elementary webkit-efl sqlite3"
SRCREV = "11"
PV = "0.2+svnr${SRCPV}"

SRC_URI = "svn://elm-browser.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit autotools

do_install_append() {
        install -d "${D}/${datadir}/pixmaps"
        install -m 0644 "${S}/resources/ventura.png" "${D}/${datadir}/pixmaps"
        install -d "${D}/${datadir}/applications"
        install -m 0644 "${S}/resources/ventura.desktop" "${D}/${datadir}/applications"
        install -d "${D}/${datadir}/ventura"
        for ico in "${S}/resources/"*.png; do
                if [ "$(basename $ico)" != "ventura.png" ]; then
                        install -m 0644 $ico "${D}/${datadir}/ventura"
                fi
        done
        install -m 0644 "${S}/resources/ventura.edj" "${D}/${datadir}/ventura"
        install -m 0644 "${S}/resources/default.edj" "${D}/${datadir}/ventura"
}

FILES_${PN} += "/usr/share/ventura/* /usr/share/applications/* /usr/share/pixmaps/*"
