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

