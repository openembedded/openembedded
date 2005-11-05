DESCRIPTION = "Opie Camera, Photo and Video Capturing Application for the Sharp CF-AG06 camera"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@vanille.de>"
LICENSE = "GPL"
RDEPENDS = "sharp-camera-support"
APPNAME = "camera"
APPTYPE = "binary"

S = "${WORKDIR}/camera"

EXTRA_QMAKEVARS_POST=" LIBS+=-L.. "
PARALLEL_MAKE = ""

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}
    install -d ${D}${palmtopdir}/lib/
    oe_libinstall -so libcamera ${D}${palmtopdir}/lib
    install -m 0755 capture ${D}${palmtopdir}/bin/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}
