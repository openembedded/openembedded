DESCRIPTION = "AbiWord is a free word processing program similar to Microsoft(r) Word"
HOMEPAGE = "http://www.abiword.org""
SECTION = "x11/office"
LICENSE = "GPLv2"
DEPENDS     = "perl-native libgsf libgnomeprint libgnomeprintui libglade libfribidi enchant jpeg libpng libxml2"
RDEPENDS    = "enchant "
RDEPENDS_linux += "glibc-gconv-ibm850 glibc-gconv-cp1252 \
                   glibc-gconv-iso8859-15 glibc-gconv-iso8859-1"
PR = "r2"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz"
S = "${WORKDIR}/abiword-${PV}/abi"

FILES_${PN} += " \
		${datadir}/icons/* \
		${datadir}/AbiSuite-2.4/AbiWord/glade \
		${datadir}/AbiSuite-2.4/AbiWord/scripts \
		${datadir}/AbiSuite-2.4/AbiWord/system.profile-en \
		${datadir}/AbiSuite-2.4/AbiWord/system.profile-en_GB \
#		${datadir}/AbiSuite-2.4/templates/A4.awt \
#		${datadir}/AbiSuite-2.4/templates/US-Letter.awt \
		${datadir}/AbiSuite-2.4/templates/normal.awt \
		${datadir}/AbiSuite-2.4/templates/normal.awt-en_GB \
		${datadir}/AbiSuite-2.4/templates/Employee-Directory.awt \
		${datadir}/AbiSuite-2.4/templates/Business-Report.awt \
		${datadir}/AbiSuite-2.4/templates/Fax-Coversheet.awt \
		${datadir}/AbiSuite-2.4/templates/Resume.awt \
		${datadir}/AbiSuite-2.4/templates/Two-Columns.awt \
		${datadir}/AbiSuite-2.4/templates/Memo.awt \
		${datadir}/AbiSuite-2.4/templates/Press-Release.awt "

inherit autotools

PARALLEL_MAKE = ""

EXTRA_OECONF = "--disable-pspell --enable-enchant"

do_install_append() {
        install -d ${D}${datadir}/pixmaps/
        mv ${D}${datadir}/icons/* ${D}${datadir}/pixmaps/
}

PACKAGES += " abiword-clipart abiword-icons abiword-strings abiword-systemprofiles abiword-templates "

FILES_abiword-clipart 		+= "${datadir}/AbiSuite-2.4/clipart"
FILES_abiword-icons 		+= "${datadir}/AbiSuite-2.4/icons"
FILES_abiword-strings 		+= "${datadir}/AbiSuite-2.4/AbiWord/strings"
FILES_abiword-systemprofiles 	+= "${datadir}/AbiSuite-2.4/AbiWord/system.profile*"
FILES_abiword-templates 	+= "${datadir}/AbiSuite-2.4/templates"
