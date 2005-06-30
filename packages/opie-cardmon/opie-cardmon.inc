DESCRIPTION = "CF/PCMCIA Card Monitor applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "cardmonapplet"
I18N_FILES = "libcardmonapplet.ts"


S = "${WORKDIR}/cardmon"

inherit opie

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
fi
 if [ -n "$D" ]; then false; fi
}

pkg_postrm() {
#!/bin/sh
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}

# FILES plugins/applets/libcardmonapplet.so* pics/cardmon/*.png sounds/cardmon/*.wav
do_install() {
        install -d ${D}${palmtopdir}/pics/cardmon/
        install -d ${D}${palmtopdir}/sounds/cardmon/
        install -m 0644 ${WORKDIR}/pics/cardmon/*.png ${D}${palmtopdir}/pics/cardmon/
        install -m 0644 ${WORKDIR}/sounds/cardmon/*.wav ${D}${palmtopdir}/sounds/cardmon/
}

