DESCRIPTION = "E-Book reader"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "opie-reader"
APPTYPE = "binary"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

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

		for f in libAportis libPlucker libppms libCHM libWeasel libiSilo   
		do
			oe_libinstall -so -C ${S}/ $f ${D}/${palmtopdir}/plugins/reader/codecs/
		done

		for f in libreader_codec libreader_pdb libreader_pluckerbase
		do
			oe_libinstall -so -C ${S}/ $f ${D}/${palmtopdir}/lib/
		done
		oe_libinstall -so -C ${S}/ libHTMLfilter ${D}/${palmtopdir}/plugins/reader/filters/
		install -m 0644 ${S}/HTMLentities ${D}/${palmtopdir}/plugins/reader/data/
		
}

