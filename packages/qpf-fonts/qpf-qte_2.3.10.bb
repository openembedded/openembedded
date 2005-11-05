DESCRIPTION = "Qt/Embedded Fonts Version ${PV}"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL QPL"
PR = "r1"

PROVIDES  = "qte-font-helvetica-100 qte-font-helvetica-120"
PROVIDES += "qte-font-fixed-70 qte-font-fixed-120"
PROVIDES += "qte-font-helvetica-80 qte-font-helvetica-140 qte-font-helvetica-180 qte-font-helvetica-240"
PROVIDES += "qte-font-smallsmooth-90"
PROVIDES += "qte-font-micro-40"
PROVIDES += "qte-font-japanese-230"
PROVIDES += "qte-font-smoothmono-90 qte-font-smoothmono-100  qte-font-smoothmono-110 qte-font-smoothmono-120"
PROVIDES += "qte-font-smoothmono-140 qte-font-smoothmono-180  qte-font-smoothmono-240"
PROVIDES += "qte-font-smoothsans-90 qte-font-smoothsans-100  qte-font-smoothsans-110 qte-font-smoothsans-120"
PROVIDES += "qte-font-smoothsans-140 qte-font-smoothsans-180  qte-font-smoothsans-240"
PROVIDES += "qte-font-smoothserif-90 qte-font-smoothserif-100  qte-font-smoothserif-110 qte-font-smoothserif-120"
PROVIDES += "qte-font-smoothserif-140 qte-font-smoothserif-180  qte-font-smoothserif-240"
PROVIDES += "qte-font-smoothtimes-100  qte-font-smoothtimes-160 qte-font-smoothtimes-170"
PROVIDES += "qte-font-smoothtimes-220 qte-font-smoothtimes-250  qte-font-smoothtimes-440"
PROVIDES += "qte-font-unifont"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-${PV}-free.tar.gz"
S = "${WORKDIR}/qt-${PV}"

inherit qpf

QPF_PKGPATTERN = "qte-font-%s"
QPF_DESCRIPTION = "Qt/E font %s"

do_install() {
	install -d ${D}${palmqtdir}/lib/fonts/
	cp -pPR lib/fonts/* ${D}${palmqtdir}/lib/fonts/
}
