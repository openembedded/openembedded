DESCRIPTION = "Scientific calculator with user definable constants and functions."
HOMEPAGE = "http://homepage3.nifty.com/cam/slcalc.htm"
SECTION = "opie/applications"
LICENSE = "GPL"
PR = "r2"

APPTYPE = "binary"
APPDESKTOP = "${S}"

SRC_URI = "http://homepage3.nifty.com/cam/slcalc_1.2.1_arm.tar.gz \
           file://slcalc2.png"

inherit opie

S = "${WORKDIR}/slcalc_source"

do_install() {
	install -d ${D}${palmtopdir}/pics
	install -m 0644 ${WORKDIR}/slcalc2.png ${D}${palmtopdir}/pics/slcalc.png
}
