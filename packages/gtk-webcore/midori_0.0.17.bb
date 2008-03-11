DESCRIPTION = "Midori is a lightweight web browser."
LICENSE = "GPLv2"

DEPENDS = "webkit-gtk libsexy" 

inherit autotools pkgconfig

SRC_URI = "http://software.twotoasts.de/media/midori/midori-${PV}.tar.gz \ 
           file://webkit-pkgconfig.patch;patch=1 \
          "
