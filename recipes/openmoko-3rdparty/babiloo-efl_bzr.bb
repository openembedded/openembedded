DESCRIPTION = "EFL Dictionary Viewer. It supports dictionaries in SDictionary and StarDict format."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Luca Vaudano <vaudano@gmail.com>"
HOMEPAGE = "http://babiloo-project.org"
RDEPENDS = "python-elementary python-compression python-misc python-netclient"

PACKAGE_ARCH = "all"

DEFAULT_PREFERENCE = "-1"
SRCREV = "296"
PV = "2.0.9-bzrr${SRCPV}"

SRC_URI = "bzr://bazaar.launchpad.net/~vaudano/babiloo/efl"

S = "${WORKDIR}/efl"

do_install() {
	install -d "${D}${datadir}/babiloo"
	cp -a "${S}/core" "${D}${datadir}/babiloo/"
	cp -a "${S}/efl" "${D}${datadir}/babiloo/"
	cp -a "${S}/images" "${D}${datadir}/babiloo/"
	cp -a "${S}/dicts" "${D}${datadir}/babiloo/"
	install -m 0755 "${S}/run.py" "${D}${datadir}/babiloo/"
	install -d "${D}${bindir}"
	ln -s "${datadir}/babiloo/run.py" "${D}${bindir}/babiloo"
	install -d "${D}${datadir}/pixmaps"
	install -m 0644 "${S}/images/babiloo.png" "${D}${datadir}/pixmaps"
	install -d "${D}${datadir}/applications"
        install -m 0644 "${S}/babiloo.desktop" "${D}${datadir}/applications"

	install -d "${D}${datadir}"
	cp -a "${S}/locale" "${D}${datadir}/"
	find ${D}${datadir}/locale -name *.po -exec rm {} \;
	rm -f ${D}${datadir}/locale/babiloo.pot

	install -d "${D}${datadir}/doc"
	install -m 0644 "${S}/doc/efl/babiloo.pdf" "${D}${datadir}/doc/"
}

FILES_${PN} += "${datadir}/babiloo"
