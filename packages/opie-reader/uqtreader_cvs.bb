DESCRIPTION = "qt4-x11 opie-reader ebook reader port"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL"

RRECOMMENDS="${PN}-filter-html"

SRCDATE = "20070601"
PV = "1.2.2opie+cvs${SRCDATE}"
PR = "r3"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
	   file://qt4.patch;patch=1"
S = "${WORKDIR}/opie-reader"

export OPIEDIR="${S}/opiedir"

inherit qt4x11

do_configure() {
	${OE_QMAKE_QMAKE} -recursive opie-reader.pro UQT_DATADIR="${datadir}/${PN}" UQT_LIBDIR="${libdir}/${PN}"
}
do_compile() {
	oe_runmake
}
do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/opiedir/bin/opie-reader ${D}${bindir}/uqtreader
	install -d ${D}${libdir}/${PN}
	cp -Rpd ${S}/opiedir/lib/lib*.so.* ${D}${libdir}
	for so in ${S}/opiedir/plugins/reader/{codecs,filters,outcodecs,support}/lib*.so ; do
		soso="${so#${S}/opiedir/plugins/reader/}"
		dd="${D}${libdir}/${PN}/$(dirname "$soso")"
		install -d "$dd"
		install -m 0755 "$so" "${dd}/$(basename "$soso")"
	done
	install -d ${D}${datadir}/${PN}
	cp -Rpd ${S}/opiedir/plugins/reader/data ${D}${datadir}/${PN}
	install -d ${D}${datadir}/${PN}/pics
	cp \
		${WORKDIR}/pics/opie-reader/*.png \
		${WORKDIR}/pics/inline/{AppsIcon,SettingsIcon,fileopen,close,cut,UtilsIcon,1to1,find,start,finish,rotate,up,down,back,home,forward,paste,fullscreen,repeat,zoom,mag,exec,new,copy,next,enter}.png \
		${D}${datadir}/${PN}/pics/
	install -d ${D}${datadir}/applications
	sed <${WORKDIR}/apps/Applications/opie-reader.desktop \
		-e '/^CanFastLoad/d' -e 's,^Icon=.*,Icon=${datadir}/${PN}/pics/OpieReader.png,g' \
		-e 's,^Exec=.*,Exec=${bindir}/uqtreader,g' \
		-e '$aType=Application' -e 'aCategories=Applications' \
		-e '/^Name/s/Opie/UQT/g' \
		>${D}${datadir}/applications/uqtreader.desktop
}
PACKAGES += "${PN}-pdblib ${PN}-codeclib \
	${PN}-codec-aportis ${PN}-codec-arrierego ${PN}-codec-chm ${PN}-codec-plucker ${PN}-codec-reb ${PN}-codec-weasel ${PN}-codec-isilo ${PN}-codec-ppms \
	${PN}-filter-html ${PN}-output-flitecmd"


FILES_${PN}-pdblib = "${libdir}/libreader_pdb.so.*"
FILES_${PN}-codeclib = "${libdir}/libreader_codec.so.*"
FILES_${PN}-codec-aportis = "${libdir}/uqtreader/codecs/libAportis.so"
FILES_${PN}-codec-arrierego = "${libdir}/uqtreader/codecs/libArriereGo.so"
FILES_${PN}-codec-chm = "${libdir}/uqtreader/codecs/libCHM.so"
DEBIAN_NOAUTONAME_${PN}-codec-plucker = 1
FILES_${PN}-codec-plucker = "${libdir}/uqtreader/codecs/libPlucker.so ${libdir}/lib*plucker*.so.* ${libdir}/uqtreader/support/libpluckerdecompress.so"
FILES_${PN}-codec-reb = "${libdir}/uqtreader/codecs/libReb.so"
FILES_${PN}-codec-weasel = "${libdir}/uqtreader/codecs/libWeasel.so"
FILES_${PN}-codec-isilo = "${libdir}/uqtreader/codecs/libiSilo.so"
FILES_${PN}-codec-ppms = "${libdir}/uqtreader/codecs/libppms.so"
FILES_${PN}-filter-html = "${libdir}/uqtreader/filters/libHTMLfilter.so"
FILES_${PN}-output-flitecmd = "${libdir}/uqtreader/outcodecs/libflitecmd.so"
FILES_${PN} = "${bindir}/uqtreader ${datadir}/uqtreader/data/* ${datadir}/uqtreader/pics/* ${datadir}/applications/*.desktop"
