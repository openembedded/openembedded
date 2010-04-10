HOMEPAGE = "http://killa.net/infosec/otpCalc/"
DESCRIPTION = "An OTP and S/Key calculator for X"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS = "gtk+ openssl"
PR = "r1"

S = "${WORKDIR}/otpCalc-${PV}"

SRC_URI = "http://killa.net/infosec/otpCalc/otpCalc-${PV}.tar.gz \
	file://otpcalc-man-table-format.diff;patch=1 \
	file://otpcalc-0.97-badindex.diff;patch=1 \
	file://otpcalc-crypto-proto.diff;patch=1 \
	file://otpcalc-0.97-gtk2-gentoo.patch;patch=1 \
	"

inherit autotools pkgconfig

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man1
	cat ${S}/otpCalc.man | sed -e "s/VERSION/${PV}/g" | gzip -c9 > ${D}${mandir}/man1/otpCalc.1.gz
	install -m 755 otpCalc ${D}${bindir}
}



SRC_URI[md5sum] = "73c9a9e95462afda725fdf17a301f0b0"
SRC_URI[sha256sum] = "e2c19fa6178ed42f0576650db6f94942cac366feadf82c2a679b35197c65f745"
