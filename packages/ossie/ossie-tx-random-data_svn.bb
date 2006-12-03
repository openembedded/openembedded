PR = "r0"
DESCRIPTION = "OSSIE transmit random bits waveform"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "ossiecf ossie-randombits ossie-modulator ossie-interpolator ossie-usrp-tx-control ossie-usrp-device ossie-gpp-device"
RDEPENDS = "ossie-randombits ossie-modulator ossie-interpolator ossie-usrp-tx-control ossie-usrp-device ossie-gpp-device"

S="${WORKDIR}/TX_Random_data"


SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/waveforms/TX_Random_data/trunk;module=TX_Random_data;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/waveforms/Random_BPSK/*.xml"
BROKEN = "1"
