PR = "r0"
DESCRIPTION = "OSSIE Waveform Loader"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "ossiecf expat"

S="${WORKDIR}/c_wavLoader"

SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/platform/c_wavLoader/trunk;module=c_wavLoader;proto=https"

inherit autotools

BROKEN = "1"
