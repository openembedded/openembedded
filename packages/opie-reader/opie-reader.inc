DESCRIPTION = "E-Book reader"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "opie-reader"
APPTYPE = "binary"

S = "${WORKDIR}/opie-reader"

EXTRA_QMAKEVARS_POST += "LIBS+=-L${S}"
PARALLEL_MAKE = ""

inherit opie

DEPENDS += " flite "
EXTRA_QMAKEVARS_POST += " SUBDIRS+=FliteDyn SUBDIRS+=FliteDyn16 "

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

        # input codes are small and should be installed together with opie-reader,
        # flite output pulls in libflite and thus should only be installed if
        # really wanted by the user
        suggests=[]
        recommends=[]
        for package in bb.data.getVar('PACKAGES', d).split():
            if 'flite' in package:
                suggests.append(package)
            else:
                recommends.append(package)
        bb.data.setVar('RRECOMMENDS_opie-reader', " ".join( recommends ), d)
        bb.data.setVar('RSUGGESTS_opie-reader', " ".join( suggests ), d)
}
