DESCRIPTION = "OTP S/Key password generator"
SECTION = "opie/applications"
HOMEPAGE = "http://www.bitrot.de/pda_otpkeygen.html"
AUTHOR = "Thomas Driemeyer <thomas@bitrot.de>"
LICENSE = "GPL"
APPTYPE="binary"
PR = "r3"

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

    install -m 0755 ${WORKDIR}/src/src ${D}${palmtopdir}/bin/otpkeygen
    install -m 0644 ${WORKDIR}/apps/Applications/otpkeygen.desktop ${D}${palmtopdir}/apps/Applications/
    install -m 0644 ${WORKDIR}/pics/otpkeygen.png ${D}${palmtopdir}/pics/
}

SRC_URI[md5sum] = "ec1c0a93a586361298faebce4fac9dbd"
SRC_URI[sha256sum] = "b6129acb788726ab159ed790a85a625651fff5cdff3a2cd0517f19ccd41c2a54"
