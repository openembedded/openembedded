DESCRIPTION = "corsair: RSS aggregator for Qtopia/OZ"
SECTION = "opie/applications"
MAINTAINER = "I dont want to have my name here. <corsair@gotontheinter.net>"
LICENSE = "GPL"
AUTHOR = "Joe Rumsey <joe@rumsey.org>"
HOMEPAGE = "http://corsair.sf.net/"
PV = "0.2.0"
CVSDATE = "20050911"
#application was released 20050910 - next versions will be released as tarballs

inherit palmtop

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/corsair;module=corsair \
           file://corsair-opie.patch;patch=1"

S = "${WORKDIR}/corsair"

do_configure() {
}

# Files: bin/corsair apps/Applications/corsair.desktop pics/Corsair.png
# pics/newfeed.png pics/get.png pics/reload.png pics/play.png

do_install() {
        install -d ${D}${palmtopdir}/pics/
        install -d ${D}${palmtopdir}/apps/Applications/
        install -d ${D}${palmtopdir}/bin
        install -m 0644 ${S}/Corsair.png ${D}${palmtopdir}/pics/
        install -m 0644 ${S}/corsair.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${S}/icons/newfeed.png ${S}/icons/get.png ${S}/icons/reload.png ${S}/icons/play.png ${D}${palmtopdir}/pics/
        install -m 0755 ${S}/corsair ${D}${palmtopdir}/bin/
}

