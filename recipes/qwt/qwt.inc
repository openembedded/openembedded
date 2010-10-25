DESCRIPTION = "Qt Widget Extension for Technical Applications"
SECTION = "libs"
PRIORITY = "optional"

# LGPLv2.1 + some exceptions
LICENSE = "QWTv1.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/qwt/qwt-${PV}.tar.bz2;name=qwt"

S = "${WORKDIR}/qwt-${PV}"

do_configure_prepend() {
	sed -i -e 's:RELEASE_SUFFIX      = :RELEASE_SUFFIX      = ${QT_LIBINFIX}:' *.pri
	sed -i -e s:lqwt:lqwt${QT_LIBINFIX}:g -e s:/usr/local/qwt-$\${QwtVersion}:${prefix}:g *.prf
}

do_install() {
	sed -i -e s:/usr/local/qwt-${PV}:${D}${prefix}:g ${S}/*.pri
	oe_runmake -e install
	install -d ${D}${datadir}/doc/${PN}
	mv ${D}${prefix}/doc/* ${D}${datadir}/doc/${PN}/
}

