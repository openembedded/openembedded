DESCRIPTION = "qt4-x11 opie-reader ebook reader port"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL"

RRECOMMENDS_${PN} = "${PN}-filter-html"

SRCDATE = "20070601"
PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_apps_opie-reader.tar.bz2;name=split_noncore_apps_opie-reader \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
	   file://qt4.patch"
SRC_URI[split_noncore_apps_opie-reader.md5sum] = "73659a51c96ce3365c2255685142c6f7"
SRC_URI[split_noncore_apps_opie-reader.sha256sum] = "657c03bc8ccb28c0cc8fbc0c46612cbaddbe47ac9ee2856015c38f9712b3a020"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
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
