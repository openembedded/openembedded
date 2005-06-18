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

# FILES bin/opie-reader apps/Applications/opie-reader.desktop pics/opie-reader/*
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/ \ 
                   ${D}${palmtopdir}/lib/ \
                   ${D}${palmtopdir}/plugins/reader/data/ \
				   ${D}${palmtopdir}/plugins/reader/filters/ \
                   ${D}${palmtopdir}/plugins/reader/codecs/ 
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

		for f in libAportis libCHM libPlucker libReb libWeasel libiSilo libppms libArriereGo
		do
			oe_libinstall -so -C ${S}/ $f ${D}${palmtopdir}/plugins/reader/codecs/
		done

		for f in libreader_codec libreader_pdb libreader_pluckerbase pluckerdecompress
		do
			oe_libinstall -so -C ${S}/ $f ${D}${palmtopdir}/lib/
		done

		oe_libinstall -so -C ${S}/ libHTMLfilter ${D}${palmtopdir}/plugins/reader/filters/
		oe_libinstall -so -C ${S}/ libpluckerdecompress ${D}${palmtopdir}/plugins/reader/support/

		for f in libflitecmd libflitedyn libflitedyn16
		do
		   oe_libinstall -so -C ${S}/ $f ${D}${palmtopdir}/plugins/reader/outcodecs
		done

		install -m 0644 ${S}/HTMLentities ${D}${palmtopdir}/plugins/reader/data/
}

