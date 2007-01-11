DESCRIPTION = "OSSIE General Purpose Processor device"
SECTION =  "apps"
PRIORITY = "optional"
MAINTAINER = "Philip Balister philip@balister.org"
LICENSE = "GPL"
PV = "0.0.0+svn${SRCDATE}"
PR = "r0"

DEPENDS = "ossiecf usrp ossie-standardinterfaces"

S="${WORKDIR}/USRP"

SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/platform/USRP/trunk;module=USRP;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/USRP/*xml"

BROKEN = "1"
