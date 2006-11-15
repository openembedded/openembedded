PR = "r0"
DESCRIPTION = "OSSIE Demo receiver component"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "ossiecf"

S="${WORKDIR}/RxDemo"


SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/components/RxDemo/trunk;module=RxDemo;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/RxDemo/*.xml"

BROKEN = "1"
