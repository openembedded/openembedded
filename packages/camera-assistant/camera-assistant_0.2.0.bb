DESCRIPTION = "Camera Assistant aims to be an allround calculator for photographers & Cinematographers. \
It currently has the following features: \
  \
  * Depth of field calculator.  \
  * Inverse Depth of field calculator. (Calculate what aperture you need for a given depth/distance & lens) \
  * Field of view calculator.  \
  * Variants of the above, calculate distance to object or lens for a given field of view.  \
  * Database of TV cameras, Motion picture cameras and Still photography cameras."
SECTION = "opie/applications"


PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "zaurus@bredband.net"
HOMEPAGE = "http://cameraassistant.sourceforge.net/"


SRC_URI = "${SOURCEFORGE_MIRROR}/cameraassistant/camera-assistant_0.2.0.tar.gz \
	  file://g++-3.4-compile-fixes.patch;patch=1 \
	  file://ca.desktop \
	  file://ca.png "
	  

S = "${WORKDIR}/CameraAssistant"

APPNAME = "ca"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}" 

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/ca.png ${D}${palmtopdir}/pics/${APPNAME}/
}


inherit opie

