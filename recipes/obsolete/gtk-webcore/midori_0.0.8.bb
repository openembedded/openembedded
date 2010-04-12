DESCRIPTION = "Midori is a lightweight web browser."
LICENSE = "GPLv2"

DEPENDS = "webkit-gtk libsexy" 

PE = "1"

inherit autotools pkgconfig

SRC_URI = "http://software.twotoasts.de/media/midori/midori-${PV}.tar.gz \ 
          "



SRC_URI[md5sum] = "069275806e0224b1de3e080c23c95dc5"
SRC_URI[sha256sum] = "7861535eef2c0804dbdc6993db76574b4a812164bed7545a3697a3b97e36d2dd"
