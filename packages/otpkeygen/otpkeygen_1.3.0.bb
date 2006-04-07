DESCRIPTION = "OTP S/Key password generator"
SECTION = "opie/applications"
HOMEPAGE = "http://www.bitrot.de/pda_otpkeygen.html"
AUTHOR = "Thomas Driemeyer <thomas@bitrot.de>"
MAINTANER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
APPTYPE="binary"
PR = "r2"

SRC_URI = "ftp://ftp.bitrot.de/pub/otpkeygen/otpkeygen-src_${PV}.tar.gz"

S = "${WORKDIR}/src/"

inherit palmtop

do_configure_prepend() {
    cd ${S} && qmake -project
}

do_install() {

    install -d ${D}${palmtopdir}/apps/Applications
    install -d ${D}${palmtopdir}/bin/
    install -d ${D}${palmtopdir}/pics/

    install -m 0755 ${WORKDIR}/src/src ${D}${palmtopdir}/bin/
    install -m 0644 ${WORKDIR}/apps/Applications/otpkeygen.desktop ${D}${palmtopdir}/apps/Applications/
    install -m 0644 ${WORKDIR}/pics/otpkeygen.png ${D}${palmtopdir}/pics/
}
