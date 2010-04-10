DESCRIPTION = "Applet for the Qtopia environment taskbar that provides an extension panel \
for the taskbar that let's you load lot's of applet's without taking up space \
in the normal taskbar."
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://sourceforge.net/projects/subapplet/"
PR = "r7"

SRC_URI = "${SOURCEFORGE_MIRROR}/subapplet/subapplet-1.0.8.tar.gz \
	file://toolbar-resize-fix.patch;patch=1"

S = "${WORKDIR}/SubApplet-1.0.8"

inherit palmtop

QMAKE_PROFILES = "subapplet.pro"

do_install() {
    install -d ${D}${palmtopdir}/plugins/applets ${D}${palmtopdir}/pics/subapplet/
    install -m 0644 *.png ${D}${palmtopdir}/pics/subapplet/
    oe_libinstall -so -C rel/opt/QtPalmtop/plugins/applets libsubapplet ${D}${palmtopdir}/plugins/applets/
}

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /usr/bin/qcop QPE/TaskBar "reloadApplets()"
else
  exit 0
fi
 if [ -n "$D" ]; then false; fi
}

pkg_postrm() {
#!/bin/sh
/usr/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}

SRC_URI[md5sum] = "6042daa703d8bd34174b195843e7ffaa"
SRC_URI[sha256sum] = "4cc4cc703bcd4da0df25e7b87b082bd9d1c836868bc4641b3c960931582dc3d2"
