DESCRIPTION = "Advanced Geocaching Tool for Linux - Towards paperless geocaching!"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Daniel Fett"
HOMEPAGE = "http://www.danielfett.de/internet-und-opensource,software,agtl"
RDEPENDS_${PN} = "python-pygtk python-html python-image python-netclient python-misc python-sqlite3 python-mime python-json"
SRCREV = "45a42994753fb396840890dd756b118790b8989e"
PV = "0.6.1.5+gitr${SRCPV}"
PR = "r2"

SRC_URI = "git://github.com/webhamster/advancedcaching.git;protocol=git;branch=master"

inherit setuptools

S = "${WORKDIR}/git/files"

do_install_append() {
        mkdir -p "${D}/${datadir}/pixmaps"
        install -m 0644 "${S}/advancedcaching.png" "${D}/${datadir}/pixmaps"
        mkdir -p "${D}/${datadir}/applications"
        install -m 0644 "${S}/advancedcaching.desktop" "${D}/${datadir}/applications"
}

FILES_${PN} += "/usr/share/applications/* /usr/share/pixmaps/*"
