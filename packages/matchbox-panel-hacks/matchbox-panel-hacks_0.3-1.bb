DESCRIPTION = "Simple dockapps created with monolaunch and shell script"
LICENSE = "MIT"
SECTION = "x11/wm"
PRIORITY = "optional"

DEPENDS = "matchbox xmodmap"

PR = "r7"

SRC_URI = "file://xrandr-panelapp.sh \
	   file://xrandr-panelapp.desktop \
	   file://xrandr.png"

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
	install -m 0755 ${WORKDIR}/xrandr-panelapp.sh ${D}${bindir}/
	install -m 0644 ${WORKDIR}/xrandr-panelapp.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/xrandr.png ${D}${datadir}/pixmaps/
}

#The package contains ashellscript, a .desktop file and a png
PACKAGE_ARCH = "all"

