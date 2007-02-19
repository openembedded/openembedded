DESCRIPTION = "OSSIE Node Booter"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "0.0.0+svn${SRCDATE}"

DEPENDS = "ossiecf"

S = "${WORKDIR}/nodebooter"

SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/platform/nodebooter/trunk;module=nodebooter;proto=https"

inherit autotools

BROKEN = "1"
