DESCRIPTION = "Applet for the Qtopia environment taskbar that provides an extension panel \
for the taskbar that let's you load lot's of applet's without taking up space \
in the normal taskbar."
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
HOMEPAGE = "http://sourceforge.net/projects/subapplet/"
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/subapplet/subapplet-1.0.8.tar.gz \
	file://toolbar-resize-fix.patch;patch=1"

S = "${WORKDIR}/SubApplet-1.0.8"

inherit palmtop

QMAKE_PROFILES = "subapplet.pro"

do_install() {
    install -d ${D}${palmtopdir}/plugins/applets ${D}${palmtopdir}/pics/subapplet/
    install -m 0644 *.png ${D}${palmtopdir}/pics/subapplet/
    oe_libinstall -so -C rel${palmtopdir}/plugins/applets libsubapplet ${D}${palmtopdir}/plugins/applets/
}

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
else
  exit 0
fi
 if [ -n "$D" ]; then false; fi
}

pkg_postrm() {
#!/bin/sh
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}
