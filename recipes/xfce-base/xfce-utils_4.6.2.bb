DESCRIPTION="Xfce4 Utilities"
DEPENDS = "virtual/libx11 libxfcegui4"
SECTION = "x11"
PR = "r0"

inherit xfce46

FILES_${PN} += " \ 
        ${bindir}/* \
        ${datadir}/dbus-1/* \
        ${datadir}/xfce4/AUTHORS \
        ${datadir}/xfce4/BSD \
        ${datadir}/xfce4/COPYING \
        ${datadir}/xfce4/GPL \
	${datadir}/xfce4/INFO* \
        ${datadir}/xfce4/LGPL \
        ${datadir}/xfce4/AUTHORS.html \
        ${datadir}/xfce4/BSD.html \
        ${datadir}/xfce4/COPYING.html \
        ${datadir}/xfce4/GPL.html \
	${datadir}/xfce4/INFO.html \
        ${datadir}/xfce4/LGPL.html \
        ${datadir}/xsessions/xfce.desktop \
"

# NOTE:  This package takes a --with-browser for the default browser
# NOTE:  Works with gdm also gtkhtml

SRC_URI[md5sum] = "5d23407700d7e8c9751e17a5bc955109"
SRC_URI[sha256sum] = "54efc2038bfbd5acaadfc91ed91fb3dfd6cec64f9402f364accce7bcafe2ba7a"
