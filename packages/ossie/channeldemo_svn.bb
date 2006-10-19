PR = "r0"
DESCRIPTION = "OSSIE Demo channel component"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "ossiecf"

S="${WORKDIR}/ChannelDemo"


SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/components/ChannelDemo/trunk;module=ChannelDemo;proto=https"

prefix="/home/sca"

inherit autotools

FILES_${PN} += "/home/sca/xml/ChannelDemo/*.xml"

