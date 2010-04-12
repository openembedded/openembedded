DESCRIPTION = "ZauRSS is an RSS aggregator for Qtopia. It can manage multiple RSS feeds. \
It can also work with NetFront3, and you can see RDF items with it. "
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
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

SRC_URI[md5sum] = "71c6e08a68aba6ed26cd80480da4160a"
SRC_URI[sha256sum] = "52e8e83cbf00e4c66dd3e862e87cfa5e468089d8aaa78ca9c2d4e1f873cb1817"
