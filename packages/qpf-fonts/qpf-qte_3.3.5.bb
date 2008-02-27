require qpf.inc

DESCRIPTION = "Qt/Embedded fonts version ${PV}"
HOMEPAGE = "http://www.trolltech.com"
LICENSE = "GPL QPL"
PR = "r6"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-free-${PV}.tar.bz2"
S = "${WORKDIR}/qt-embedded-free-${PV}"

do_compile() {
	:
}

do_install() {
	mkdir -p ${D}${sbindir}
	mkdir -p ${D}${palmtopdir}/lib/fonts
	cp -pPR lib/fonts/* ${D}${palmtopdir}/lib/fonts
	# Delete all other font formats, Qt/E would have a dead slow
	# application start time if it had to use any other font format
	# as *.qpf ...
	find ${D}${palmtopdir}/lib/fonts \
	     -name "*.bdf" \
	  -o -name "*.ttf" \
	  -o -name "*.pfa" \
	  -o -name "*.pfb" | xargs rm
}

PACKAGES = "qte-font-fixed"
PROVIDES += "qte-font-fixed"
FILES_qte-font-fixed = "${palmtopdir}/lib/fonts/fixed*"

PACKAGES += "qte-font-helvetica-small"
PROVIDES += "qte-font-helvetica-small"
FILES_qte-font-helvetica-small = "${palmtopdir}/lib/fonts/helvetica_80*.qpf \
	${palmtopdir}/lib/fonts/helvetica_100*.qpf ${palmtopdir}/lib/fonts/helvetica_120*.qpf"

PACKAGES += "qte-font-helvetica-large"
PROVIDES += "qte-font-helvetica-large"
FILES_qte-font-helvetica-large = "${palmtopdir}/lib/fonts/helvetica_140*.qpf \
	${palmtopdir}/lib/fonts/helvetica_180*.qpf ${palmtopdir}/lib/fonts/helvetica_240*.qpf"

PACKAGES += "qte-font-smoothtimes"
PROVIDES += "qte-font-smoothtimes"
FILES_qte-font-smoothtimes = "${palmtopdir}/lib/fonts/smoothtimes*"

PACKAGES += "qte-font-smallsmooth"
PROVIDES += "qte-font-smallsmooth"
FILES_qte-font-smallsmooth = "${palmtopdir}/lib/fonts/smallsmooth*"

PACKAGES += "qte-font-unicode"
PROVIDES += "qte-font-unicode"
FILES_qte-font-unicode = "${palmtopdir}/lib/fonts/unifont*.qpf"

PACKAGES += "qte-font-micro"
PROVIDES += "qte-font-micro"
FILES_qte-font-micro = "${palmtopdir}/lib/fonts/micro*.qpf"
