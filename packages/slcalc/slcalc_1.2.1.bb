DESCRIPTION = "Scientific calculator with user definable constants and functions."
HOMEPAGE = "http://homepage3.nifty.com/cam/slcalc.htm"
SECTION = "opie/applications"
LICENSE = "GPL"
PR = "r1"

APPTYPE = "binary"
APPDESKTOP = "${S}"

SRC_URI = "http://homepage3.nifty.com/cam/slcalc_1.2.1_arm.tar.gz"

inherit opie

S = "${WORKDIR}/slcalc_source"

do_install() {
	install -d ${D}${palmtopdir}/pics
	install -m 0644 slcalc2.png ${D}${palmtopdir}/pics/slcalc.png
}
