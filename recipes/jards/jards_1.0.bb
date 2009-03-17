DESCRIPTION = "Reference and training tool for students of Japanese"
AUTHOR = "Johnny Andersson"
HOMEPAGE = "http://gakusei.sf.net"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "virtual/japanese-font qte-mt libpng (>= 1) kpengine"
PR = "r7"

#  stuff that still needs fixing
#) is the RDEPENDS line correct and sufficient?
#) upon execution there is a message that /usr/lib/libpng12.so.0 does not have version information
#) desktop icon missing
#) Desktop png file an falscher Stelle, daher kein Icon
#) remove .debug dir
#) es fehlen: ./opt/QtPalmtop/bin/kpengine, ./opt/QtPalmtop/jardsmob/edict.jardsdic, ./opt/QtPalmtop/jardsmob/kanjidic.jardskdic
#) exec muß jardsmob_bin heißen
#) Programm geht oft in 100% CPU schleife -> unbenutzbar

SRC_URI = "${SOURCEFORGE_MIRROR}/gakusei/jards_gakusei.cvs.sourceforge.net__20070212.tar.gz"
#SRC_URI = "cvs://anonymous@gakusei.cvs.sourceforge.net/cvsroot/gakusei;method=pserver;module=jards"

inherit opie

OE_QMAKE_CXXFLAGS := "${@oe_filter_out('-fno-rtti', '${OE_QMAKE_CXXFLAGS}', d)}"

S = "${WORKDIR}/${PN}/"
export OE_QMAKE_LINK="${CXX}"

# read opie.bbclass
#APPDESKTOP = "${S}"
APPTYPE = "binary"
APPNAME = "jardsmob"

FILES_${PN}-dbg += "${D}${palmtopdir}/bin/.debug/"

PARALLEL_MAKE = ""

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -d ${D}${palmtopdir}/pics/
	install -d ${D}${palmtopdir}/${APPNAME}/images
        install -d ${D}${palmtopdir}/apps/Applications
	install -m 0644 ${S}dat/images/jardsmob.png ${D}${palmtopdir}/pics/
	install -m 0644 ${S}dat/images/*.png ${D}${palmtopdir}/${APPNAME}/images/
	install -m 0755 ${S}jardsmob_bin ${D}${palmtopdir}/bin/
	install -m 0644 ${WORKDIR}/jards/jards.desktop ${D}${palmtopdir}/apps/Applications/

	# what about the following files: edict.jardsdic kanjidic.jardskdic?
	for f in markers romkana.utf8 strokedata wordfreq_ck raddat.utf8
	do
		install -m 0644 ${S}dat/$f ${D}${palmtopdir}/${APPNAME}/
	done
}

