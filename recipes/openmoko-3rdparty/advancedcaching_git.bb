DESCRIPTION = "Advanced Geocaching Tool for Linux - Towards paperless geocaching!"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.opkg.org/package_268.html"
RDEPENDS = "python-pygtk python-html python-image python-netclient python-misc python-sqlite3 python-mime python-json"
SRCREV = "9c3661f5573d2dd712437f1590070153d12e4c02"
PV = "0.1.2+gitr${SRCREV}"

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
