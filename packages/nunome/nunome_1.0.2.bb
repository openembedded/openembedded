DESCRIPTION = "Japanese input method plugin"
HOMEPAGE = "http://www.sikigami.com/nunome-Qtopia-1.0/"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "virtual/japanese-font"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/gakusei/nunome-${PV}.tar.bz2 \
	file://timer.patch;patch=1 \
	file://nunome.patch;patch=1"
S = "${WORKDIR}/nunome"

inherit opie

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${S}/Nnmlib INCLUDEPATH+=${S}/ui LIBS+=-L${S}"
OE_QMAKE_CXXFLAGS := "${@oe_filter_out('-fno-rtti', '${OE_QMAKE_CXXFLAGS}', d)}"
PARALLEL_MAKE = ""

do_configure_prepend() {
	sed -i -e 's,/opt/QtPalmtop/bin/,${bindir}/,g' "${S}/ui/nunome.h"
	sed -i -e 's,/opt/QtPalmtop/,${palmtopdir}/,g' "${S}/ui/nunome.h"
	printf "TEMPLATE=subdirs\nSUBDIRS=Nnmlib server ui dicman ui\n" >nunome.pro
	pushd Nnmlib && qmake -project -t lib && popd
	pushd server && qmake -project && printf "LIBS+=-lNnmlib\nTARGET=server.bin\n" >> server.pro && popd
	pushd dicman && qmake -project && printf "LIBS+=-lnunome -lNnmlib\nTARGET=dicman.bin\n" >> dicman.pro && popd
	pushd ui && qmake -project -t lib && printf "LIBS+=-lNnmlib\nTARGET=nunome\n" >> ui.pro && popd
	find . -name "moc*"|xargs rm -f
	find . -name "Makefile"|xargs rm -f
}

do_install() {
	install -d ${D}${palmtopdir}/lib
	install -d ${D}${bindir}
	install -d ${D}${palmtopdir}/i18n/ja
	install -d ${D}${palmtopdir}/share/nunome

	oe_libinstall -so libNnmlib ${D}${palmtopdir}/lib
        install -m 644 nunome_uni.dic  		${D}${palmtopdir}/share/nunome
        install -m 755 server.bin        	${D}${bindir}/nnmsrv
        install -m 755 dicman.bin		${D}${bindir}/nnmDicman
        install -m 644 ui/nunome.qm		${D}${palmtopdir}/i18n/ja
        install -m 644 dicman/nnmDicman.qm  	${D}${palmtopdir}/i18n/ja
}
