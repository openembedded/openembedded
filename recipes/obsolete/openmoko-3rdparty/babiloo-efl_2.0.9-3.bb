DESCRIPTION = "EFL Dictionary Viewer. It supports dictionaries in SDictionary and StarDict format."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Luca Vaudano <vaudano@gmail.com>"
HOMEPAGE = "http://babiloo-project.org"
RDEPENDS = "python-elementary python-compression python-misc python-netclient"

PACKAGE_ARCH = "all"

PV = "2.0.9-3"
PR = "r0"

SRC_URI = "http://bazaar.launchpad.net/%7Evaudano/babiloo/efl/download/head%3A/babiloo_2.0.93.tar.g-20091127144609-qfgdm9zxdc47ap4y-1/babiloo_2.0.9-3.tar.gz;name=tarball"
SRC_URI[tarball.md5sum] = "3f254dbbe7dd7a4c9527e1e17686101b"
SRC_URI[tarball.sha256sum] = "4c4eacd8d8aec7ec7f325c18c8401d6d09986b77ddce317768360fccef78e3ef"

S = "${WORKDIR}/babiloo"

do_install() {
	install -d "${D}${datadir}/babiloo"
	install -d "${D}${datadir}/babiloo/dicts"

	cp -a "${S}/core" "${D}${datadir}/babiloo/"
	cp -a "${S}/efl" "${D}${datadir}/babiloo/"
	cp -a "${S}/images" "${D}${datadir}/babiloo/"
	install -m 0755 "${S}/run.py" "${D}${datadir}/babiloo/"
	install -d "${D}${bindir}"
	ln -s "${datadir}/babiloo/run.py" "${D}${bindir}/babiloo"
	install -d "${D}${datadir}/pixmaps"
	install -m 0644 "${S}/images/babiloo.png" "${D}${datadir}/pixmaps"
	install -d "${D}${datadir}/applications"
        install -m 0644 "${S}/babiloo.desktop" "${D}${datadir}/applications"

	#cp -a "${S}/locale" "${D}${datadir}/"
	#find ${D}${datadir}/locale -name *.po -exec rm {} \;
	#rm -f ${D}${datadir}/locale/babiloo.pot
}

FILES_${PN} += "${datadir}/babiloo"
