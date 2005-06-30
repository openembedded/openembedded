SECTION = "x11/fonts"	#maybe this should be "fonts/ttf"?
PRIORITY = "optional"
PACKAGE_ARCH = "all"
#DEPENDS = "fontconfig"
#RSUGGESTS = "libfontconfig-utils"

# I dont want TTF fonts to depend on fontconfig on device
# as those fonts can be used not only in X11 enviroment
# for example I use them with OPIE

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    install -m 0644 ${S}/*.ttf ${D}${datadir}/fonts/truetype/
}

#pkg_postinst () {
##!/bin/sh
#fc-cache
#}
