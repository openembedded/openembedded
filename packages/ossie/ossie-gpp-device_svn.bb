PR = "r0"
DESCRIPTION = "OSSIE General Purpose Processor device"
SECTION =  "apps"
PRIORITY = "optional"
MAINTAINER = "Philip Balister philip@balister.org"
LICENSE = "GPL"

DEPENDS = "ossiecf"

S="${WORKDIR}/GPP"

SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/platform/GPP/trunk;module=GPP;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/GPP/*xml"

BROKEN = "1"
