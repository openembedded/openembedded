DESCRIPTION = "Simple Image Viewer"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "showimg"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/multimedia/showimg \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libshowimg.so* bin/showimg apps/Applications/showimg.desktop pics/imageviewer
do_install() {
        install -d ${D}${palmtopdir}/pics/imageviewer/
        install -m 0644 ${WORKDIR}/pics/imageviewer/*.png ${D}${palmtopdir}/pics/imageviewer/
}

