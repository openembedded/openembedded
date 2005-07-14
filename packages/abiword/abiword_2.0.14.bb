DESCRIPTION = "AbiWord Word Processor"

DEPENDS     = "cdump-native libfribidi enchant jpeg libpng perl glibc libxml2"
RDEPENDS    = "enchant glibc-gconv-ibm850 glibc-gconv-cp1252 \
               glibc-gconv-iso8859-15 glibc-gconv-iso8859-1"

BROKEN = "1"
inherit autotools

PR = "r0"

S = "${WORKDIR}/abiword-${PV}/abi"

SRC_URI = "http://download.sourceforge.net/abiword/abiword-${PV}.tar.bz2"

FILES_${PN} += "${datadir}/icons/* \
${datadir}/AbiSuite-2.0/AbiWord/glade \
${datadir}/AbiSuite-2.0/AbiWord/scripts \
${datadir}/AbiSuite-2.0/AbiWord/system.profile-en \
${datadir}/AbiSuite-2.0/AbiWord/system.profile-en_GB \
#${datadir}/AbiSuite-2.0/templates/A4.awt \
#${datadir}/AbiSuite-2.0/templates/US-Letter.awt \
${datadir}/AbiSuite-2.0/templates/normal.awt \
${datadir}/AbiSuite-2.0/templates/normal.awt-en_GB \
${datadir}/AbiSuite-2.0/templates/Employee-Directory.awt \
${datadir}/AbiSuite-2.0/templates/Business-Report.awt \
${datadir}/AbiSuite-2.0/templates/Fax-Coversheet.awt \
${datadir}/AbiSuite-2.0/templates/Resume.awt \
${datadir}/AbiSuite-2.0/templates/Two-Columns.awt \
${datadir}/AbiSuite-2.0/templates/Memo.awt \
${datadir}/AbiSuite-2.0/templates/Press-Release.awt"

#abiword needs this native tool
export BUILD_CDUMPTOOL="${STAGING_BINDIR}/cdump"

PARALLEL_MAKE=""

do_configure () {
	cd ${S}
	./autogen.sh
	./configure --prefix=/usr --host=${TARGET_SYS} --disable-pspell --enable-enchant
#	--enable-debug
}

do_install_append() {
	install -d ${D}${datadir}/pixmaps/
	mv ${D}${datadir}/icons/* ${D}${datadir}/pixmaps/
}

