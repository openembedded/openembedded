DESCRIPTION = "qt4-x11 opie-reader ebook reader port"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL"

RRECOMMENDS="${PN}-filter-html"

S = "${WORKDIR}/opie-reader"
PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
	   file://qt4.patch;patch=1"

export OPIEDIR="${S}/opiedir"

inherit qmake-base qt4x11

do_configure() {
	${OE_QMAKE_QMAKE} -recursive opie-reader.pro
}
do_compile() {
	oe_runmake
}
do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/opiedir/bin/opie-reader ${D}/usr/bin/uqtreader
	install -d ${D}/usr/lib/uqtreader
	cp -Rpd ${S}/opiedir/{lib,plugins/reader/support}/lib*.so.* ${D}/usr/lib/
	for so in ${S}/opiedir/plugins/reader/{codecs,filters,outcodecs}/lib*.so ; do
		soso="${so#${S}/opiedir/plugins/reader/}"
		dd="${D}/usr/lib/uqtreader/$(dirname "$soso")"
		install -d "$dd"
		install -m 0755 "$so" "${dd}/$(basename "$soso")"
	done
	install -d ${D}/usr/share/uqtreader
	cp -Rpd ${S}/opiedir/plugins/reader/data ${D}/usr/share/uqtreader/
	install -d ${D}/usr/share/uqtreader/pics
	cp \
		${WORKDIR}/pics/opie-reader/*.png \
		${WORKDIR}/pics/inline/{AppsIcon,SettingsIcon,fileopen,close,cut,UtilsIcon,1to1,find,start,finish,rotate,up,down,back,home,forward,paste,fullscreen,repeat,zoom,mag,exec,new,copy,next,enter}.png \
		${D}/usr/share/uqtreader/pics/
	install -d ${D}/usr/share/applications
	sed <${WORKDIR}/apps/Applications/opie-reader.desktop \
		-e '/^CanFastLoad/d' -e 's,^Icon=.*,Icon=/usr/share/uqtreader/pics/OpieReader.png,g' \
		-e 's,^Exec=.*,Exec=/usr/bin/uqtreader,g' \
		-e '$aType=Application' -e 'aCategories=Applications' \
		-e '/^Name/s/Opie/UQT/g' \
		>${D}/usr/share/applications/uqtreader.desktop
}
PACKAGES += "${PN}-pdblib ${PN}-codeclib \
	${PN}-codec-aportis ${PN}-codec-arrierego ${PN}-codec-chm ${PN}-codec-plucker ${PN}-codec-reb ${PN}-codec-weasel ${PN}-codec-isilo ${PN}-codec-ppms \
	${PN}-filter-html ${PN}-output-flitecmd"


FILES_${PN}-pdblib = "/usr/lib/libreader_pdb.so.*"
FILES_${PN}-codeclib = "/usr/lib/libreader_codec.so.*"
FILES_${PN}-codec-aportis = "/usr/lib/uqtreader/codecs/libAportis.so"
FILES_${PN}-codec-arrierego = "/usr/lib/uqtreader/codecs/libArriereGo.so"
FILES_${PN}-codec-chm = "/usr/lib/uqtreader/codecs/libCHM.so"
FILES_${PN}-codec-plucker = "/usr/lib/uqtreader/codecs/libPlucker.so /usr/lib/lib*plucker*.so.*"
DEBIAN_NOAUTONAME_${PN}-codec-plucker = 1
FILES_${PN}-codec-reb = "/usr/lib/uqtreader/codecs/libReb.so"
FILES_${PN}-codec-weasel = "/usr/lib/uqtreader/codecs/libWeasel.so"
FILES_${PN}-codec-isilo = "/usr/lib/uqtreader/codecs/libiSilo.so"
FILES_${PN}-codec-ppms = "/usr/lib/uqtreader/codecs/libppms.so"
FILES_${PN}-filter-html = "/usr/lib/uqtreader/filters/libHTMLfilter.so"
FILES_${PN}-output-flitecmd = "/usr/lib/uqtreader/outcodecs/libflitecmd.so"
FILES_${PN} = "/usr/bin/uqtreader /usr/share/uqtreader/data/* /usr/share/uqtreader/pics/* /usr/share/applications/*.desktop"
