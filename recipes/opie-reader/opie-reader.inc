DESCRIPTION = "E-Book reader"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "opie-reader"
APPTYPE = "binary"
DEPENDS = "flite"
RRECOMMENDS_PN = "opie-reader-filter-htmlfilter, opie-reader-codec-weasel, opie-reader-codec-reb, \
  opie-reader-codec-isilo, opie-reader-codec-aportis, opie-reader-codec-ppms, opie-reader-codec-chm, \
  opie-reader-codec-plucker, opie-reader-codec-arrierego"
RSUGGESTS_PN = "opie-reader-output-flitedyn16, opie-reader-output-flitecmd, opie-reader-output-flitedyn"
INC_PR = "r3"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
S = "${WORKDIR}/opie-reader"

EXTRA_QMAKEVARS_POST += "LIBS+=-L${S}"
PARALLEL_MAKE = ""

inherit opie

EXTRA_QMAKEVARS_POST += " SUBDIRS+=FliteDyn SUBDIRS+=FliteDyn16 INCLUDEPATH+=${STAGING_INCDIR}/flite"

do_install() {
		install -d ${D}${palmtopdir}/pics/${APPNAME}/
		install -d ${D}${palmtopdir}/lib/
		install -d ${D}${palmtopdir}/plugins/reader/data/
		install -d ${D}${palmtopdir}/plugins/reader/filters/
		install -d ${D}${palmtopdir}/plugins/reader/support/
		install -d ${D}${palmtopdir}/plugins/reader/outcodecs/
		install -d ${D}${palmtopdir}/plugins/reader/codecs/ 
		install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

		for f in libAportis libCHM libPlucker libReb libWeasel libiSilo libppms libArriereGo
		do
			install -m 644 ${S}/$f.so ${D}${palmtopdir}/plugins/reader/codecs/
		done

		for f in libreader_codec libreader_pdb libreader_pluckerbase pluckerdecompress
		do
			oe_libinstall -so -C ${S}/ $f ${D}${palmtopdir}/lib/
		done

		install -m 644 ${S}/libHTMLfilter.so ${D}${palmtopdir}/plugins/reader/filters/
		install -m 644 ${S}/libpluckerdecompress.so ${D}${palmtopdir}/plugins/reader/support/

		for f in libflitecmd libflitedyn libflitedyn16
		do
		   install -m 644 ${S}/$f.so ${D}${palmtopdir}/plugins/reader/outcodecs
		done

		install -m 0644 ${S}/HTMLentities ${D}${palmtopdir}/plugins/reader/data/
}

python populate_packages_prepend () {
        print "opie-reader:", bb.data.getVar( 'RDEPENDS_opie-reader', d )
        plugindir = bb.data.expand('${palmtopdir}/plugins/reader', d)                                     
        for dir, type in [ ( 'codecs', 'codec' ), ( 'filters', 'filter' ), ( 'outcodecs', 'output' ) ]:
            dir = plugindir + '/' + dir
            do_split_packages(d, dir,
                              '^lib(.*)\.so$', 'opie-reader-' + type + '-%s',
                              'Opie reader %s ' + type,
                              prepend=True)

}
