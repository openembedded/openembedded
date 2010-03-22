DESCRIPTION = "EFL Dictionary Viewer. It supports dictionaries in SDictionary and StarDict format."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Luca Vaudano <vaudano@gmail.com>"
HOMEPAGE = "http://babiloo-project.org"
RDEPENDS = "python-elementary python-compression python-misc python-netclient"

PACKAGE_ARCH = "all"

PV = "2.0.9-10"
PR = "r1"

SRC_URI = "http://www.vaudano.eu/projects/babiloo/babiloo_2.0.9-10.tar.gz;name=tarball"
SRC_URI[tarball.md5sum] = "2a66cc5863aca83c4b3120b8ca974676"
SRC_URI[tarball.sha256sum] = "42bba5f09875c8d3a8d4579a79ade86207a095b6d4741cc3a72bee071c22bb46"

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
