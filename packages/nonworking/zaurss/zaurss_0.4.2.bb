DESCRIPTION = "ZauRSS is an RSS aggregator for Qtopia. It can manage multiple RSS feeds. \
It can also work with NetFront3, and you can see RDF items with it. "
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
HOMEPAGE = "http://www.daionet.gr.jp/~knok/software/zaurss/"
APPNAME = "zaurss"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"
PR = "r0"

SRC_URI = "http://www.daionet.gr.jp/~knok/software/zaurss/zaurss-${PV}.tar.gz"

inherit opie

OE_QMAKE_INCDIR_QT = "${STAGING_INCDIR}/qpe"
EXTRA_QMAKEVARS_POST = "INCLUDEPATH=dialog               \
                        INCLUDEPATH+=qhttp                \
                        INCLUDEPATH+=${QTDIR}/include"

do_configure_prepend() {
	rm -f Makefile
	find . -name "moc*"|xargs rm -f
}

do_install () {
	install -d ${D}/${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/*.png ${D}/${palmtopdir}/pics/
	
}
