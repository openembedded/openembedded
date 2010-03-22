DESCRIPTION = "EFL Dictionary Viewer. It supports dictionaries in SDictionary and StarDict format."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Luca Vaudano <vaudano@gmail.com>"
HOMEPAGE = "http://babiloo-project.org"
RDEPENDS = "python-elementary python-compression python-misc python-netclient"

PACKAGE_ARCH = "all"

PV = "2.0.9-4"
PR = "r1"

SRC_URI = "http://bazaar.launchpad.net/%7Evaudano/babiloo/efl/download/head%3A/babiloo_2.0.94.tar.g-20091201105555-efky7gi6fkm39xw8-2/babiloo_2.0.9-4.tar.gz;name=tarball"
SRC_URI[tarball.md5sum] = "f5f25daff7accb8d409fa9f94c49fc17"
SRC_URI[tarball.sha256sum] = "28fc4550f986512aaa96ebf776f16d3cb9d9b493ac1805642def54c8167a0f74"

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

	cp -a "${S}/locale" "${D}${datadir}/"
	find ${D}${datadir}/locale -name *.po -exec rm {} \;
	rm -f ${D}${datadir}/locale/babiloo.pot
}

FILES_${PN} += "${datadir}/babiloo"
