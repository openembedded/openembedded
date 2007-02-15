DESCRIPTION = "OSSIE Demo receiver component"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "0.0.0+svn${SRCDATE}"

DEPENDS = "ossiecf"

S = "${WORKDIR}/RxDemo"


SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/components/RxDemo/trunk;module=RxDemo;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/RxDemo/*.xml"

BROKEN = "1"
