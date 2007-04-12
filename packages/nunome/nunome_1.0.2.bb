DESCRIPTION = "Japanese input method plugin"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.sikigami.com/nunome-Qtopia-1.0/"
RDEPENDS = "virtual/japanese-font"

SRC_URI = "${SOURCEFORGE_MIRROR}/gakusei/nunome-${PV}.tar.bz2 \
	file://nunome.patch;patch=1"
S = "${WORKDIR}/nunome"

inherit opie

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${S}/Nnmlib INCLUDEPATH+=${S}/ui LIBS+=-L${S}"
OE_QMAKE_CXXFLAGS := "${@oe_filter_out('-fno-rtti', '${OE_QMAKE_CXXFLAGS}', d)}"
PARALLEL_MAKE = ""

do_configure_prepend() {
	echo -e "TEMPLATE=subdirs\nSUBDIRS=Nnmlib server ui dicman ui" >nunome.pro
	pushd Nnmlib && qmake -project -t lib && popd
	pushd server && qmake -project && echo -e "LIBS+=-lNnmlib\nTARGET=server.bin" >> server.pro && popd
	pushd dicman && qmake -project && echo -e "LIBS+=-lnunome -lNnmlib\nTARGET=dicman.bin" >> dicman.pro && popd
	pushd ui && qmake -project -t lib && echo -e "LIBS+=-lNnmlib\nTARGET=nunome" >> ui.pro && popd
	find . -name "moc*"|xargs rm -f
	find . -name "Makefile"|xargs rm -f
}

do_install() {
	install -d ${D}${palmtopdir}/lib
	install -d ${D}${palmtopdir}/bin
	install -d ${D}${palmtopdir}/i18n/ja
	install -d ${D}${palmtopdir}/share/nunome

	oe_libinstall -so libNnmlib ${D}${palmtopdir}/lib
        install -m 644 nunome_uni.dic  		${D}${palmtopdir}/share/nunome
        install -m 755 server.bin        	${D}${palmtopdir}/bin/nnmsrv
        install -m 755 dicman.bin		${D}${palmtopdir}/bin/nnmDicman
        install -m 644 ui/nunome.qm		${D}${palmtopdir}/i18n/ja
        install -m 644 dicman/nnmDicman.qm  	${D}${palmtopdir}/i18n/ja
}
