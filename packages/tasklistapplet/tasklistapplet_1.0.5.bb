DESCRIPTION = "TaskList Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
HOMEPAGE = "http://sourceforge.net/projects/subapplet/"

SRC_URI = "${SOURCEFORGE_MIRROR}/subapplet/tasklist-105.tar.gz"

S = "${WORKDIR}/TaskList-1.0.5"

inherit palmtop

#QMAKE_PROFILES = "subapplet.pro"

do_install() {
    install -d ${D}${palmtopdir}/plugins/applets ${D}${palmtopdir}/pics/tasklist/
    install -m 0644 icons/*.png ${D}${palmtopdir}/pics/tasklist/
    oe_libinstall -so -C rel/opt/Qtopia/plugins/applets libtasklistapplet ${D}${palmtopdir}/plugins/applets/
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
