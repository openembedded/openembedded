PR = "r0"
DESCRIPTION = "OSSIE Modulator component"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "ossiecf ossie-standardinterfaces ossie-sigproc"

S="${WORKDIR}/Modulator"


SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/components/Modulator/trunk;module=Modulator;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/Modulator/*.xml"

BROKEN = "1"
