PR = "r0"
DESCRIPTION = "OSSIE Demo waveform"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "ossiecf channeldemo rxdemo"

S="${WORKDIR}/ossie_demo"


SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/waveforms/ossie_demo/trunk;module=ossie_demo;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/waveforms/ossie_demo/*.xml /home/sca/xml/TxDemo/*.xml"
