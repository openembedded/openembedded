DESCRIPTION="XFCE4 Utilities"
DEPENDS = "virtual/libx11 libxfcegui4"
SECTION = "x11"
PR = "r3"

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

SRC_URI[md5sum] = "1aa2362b11e79e56d52ce0d265faf1b6"
SRC_URI[sha256sum] = "8310ad3694567dc7cbe0d57f4283712ca9e576ca73c9dc53a576b546f0b6b571"
