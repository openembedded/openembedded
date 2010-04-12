DESCRIPTION = "MKbot is a modular IRC bot written in C++, using the Qt 4 toolkit. \
It currently works on networks running hybrid-ircd such as Freenode, and the unreal3 ircd"
HOMEPAGE = "http://fredemmott.co.uk/index.php?page=mkbot"
AUTHOR = "Fred Emmott"
LICENSE = "GPL"
SECTION = "network"

SRC_URI = "http://files.fredemmott.co.uk/mkbot-${PV}.tar.bz2"
S = "${WORKDIR}/MKbot-0.3"

inherit qt4x11

#FIXME: lacks packaging

SRC_URI[md5sum] = "094b5693c602c5d872e49e24d2747ef2"
SRC_URI[sha256sum] = "c1cace2663ee1ff32f95d14fc60a6b7eee3ec8e3d0e7c531e9a778bbf29960a1"
