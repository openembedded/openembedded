DESCRIPTION ="AbiWord is free word processing program similar to Microsoft(r) Word""
HOMEPAGE="http://www.abiword.org""
MAINTAINER="Koen Kooi <koen@handhelds.org>"
LICENSE="GPLv2"

DEPENDS     = "cdump-native libglade libfribidi enchant jpeg libpng perl glibc"
RDEPENDS    = "enchant glibc-gconv-ibm850 glibc-gconv-cp1252 \
               glibc-gconv-iso8859-15 glibc-gconv-iso8859-1"
PR="r2"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz \
	file://cdump-hack.patch;patch=1"
S = "${WORKDIR}/abiword-${PV}/abi"

FILES_${PN} += " ${datadir}/icons/* \
${datadir}/AbiSuite-2.2/AbiWord/glade \
${datadir}/AbiSuite-2.2/AbiWord/scripts \
${datadir}/AbiSuite-2.2/AbiWord/system.profile-en \
${datadir}/AbiSuite-2.2/AbiWord/system.profile-en_GB \
#${datadir}/AbiSuite-2.2/templates/A4.awt \
#${datadir}/AbiSuite-2.2/templates/US-Letter.awt \
${datadir}/AbiSuite-2.2/templates/normal.awt \
${datadir}/AbiSuite-2.2/templates/normal.awt-en_GB \
${datadir}/AbiSuite-2.2/templates/Employee-Directory.awt \
${datadir}/AbiSuite-2.2/templates/Business-Report.awt \
${datadir}/AbiSuite-2.2/templates/Fax-Coversheet.awt \
${datadir}/AbiSuite-2.2/templates/Resume.awt \
${datadir}/AbiSuite-2.2/templates/Two-Columns.awt \
${datadir}/AbiSuite-2.2/templates/Memo.awt \
${datadir}/AbiSuite-2.2/templates/Press-Release.awt "

inherit autotools

#abiword needs this native tool
export BUILD_CDUMPTOOL=${STAGING_BINDIR}/cdump

PARALLEL_MAKE=""

do_configure () {
        cd ${S}
        ./autogen.sh
        ./configure --prefix=/usr --host=${TARGET_SYS} --disable-pspell --enable-enchant
#       --enable-debug
	cp -f ${STAGING_BINDIR}/cdump src/tools/cdump/xp/
}

do_install_append() {
        install -d ${D}${datadir}/pixmaps/
        mv ${D}${datadir}/icons/* ${D}${datadir}/pixmaps/
}


