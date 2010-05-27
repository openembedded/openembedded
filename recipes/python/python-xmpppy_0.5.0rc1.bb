DESCRIPTION = "Library for handling xmpp with python"
HOMEPAGE = "http://sourceforge.net/projects/xmpppy/"
SECTION = "devel/python"
LICENSE = "GPL"
SOURCE = "xmpppy"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SOURCE}/${SOURCE}-${PV}.tar.gz"
SRC_URI[md5sum] = "e0d2b3f9e4a278c163431e64adb0c861"
SRC_URI[sha256sum] = "519b025b3c9600c26c5805d0c612fe01e61330d2b9869f05c7c416c627820b9a"

S = "${WORKDIR}/${SOURCE}-${PV}"

inherit setuptools
