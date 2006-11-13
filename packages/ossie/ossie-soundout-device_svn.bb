PR = "r0"
DESCRIPTION = "OSSIE sound playback device"
SECTION =  "apps"
PRIORITY = "optional"
MAINTAINER = "Philip Balister philip@balister.org"
LICENSE = "GPL"

DEPENDS = "alsa-lib ossiecf ossie-standardinterfaces"

S="${WORKDIR}/Sound_out"

SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/platform/Sound_out/trunk;module=Sound_out;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/soundCard/*xml"

