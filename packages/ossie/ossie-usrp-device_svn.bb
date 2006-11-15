PR = "r0"
DESCRIPTION = "OSSIE General Purpose Processor device"
SECTION =  "apps"
PRIORITY = "optional"
MAINTAINER = "Philip Balister philip@balister.org"
LICENSE = "GPL"

DEPENDS = "ossiecf usrp ossie-standardinterfaces"

S="${WORKDIR}/USRP"

SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/platform/USRP/trunk;module=USRP;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/USRP/*xml"

BROKEN = "1"
