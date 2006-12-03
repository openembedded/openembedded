PR = "r0"
DESCRIPTION = "OSSIE Interpolator component"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "ossiecf ossie-standardinterfaces ossie-sigproc"

S="${WORKDIR}/Interpolator"


SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/components/Interpolator/trunk;module=Interpolator;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/Interpolator/*.xml"

BROKEN = "1"
