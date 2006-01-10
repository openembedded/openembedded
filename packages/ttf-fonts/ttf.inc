SECTION = "x11/fonts"
PRIORITY = "optional"
PACKAGE_ARCH = "all"
#DEPENDS = "fontconfig opie-ttf-support"
#RSUGGESTS = "fontconfig-utils opie-ttf-support"

# I dont want TTF fonts to depend on fontconfig on device
# as those fonts are used not only in X11 enviroment

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    install -m 0644 ${S}/*.ttf ${D}${datadir}/fonts/truetype/
}

#pkg_postinst () {
##!/bin/sh
#fc-cache
#}
