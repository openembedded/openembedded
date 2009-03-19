DESCRIPTION = "CF/SD/PCMCIA Card Monitor applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "cardapplet"
I18N_FILES = "libcardapplet.ts"


S = "${WORKDIR}/cardapplet"

inherit opie

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /usr/bin/qcop QPE/TaskBar "reloadApplets()"
fi
 if [ -n "$D" ]; then false; fi
}

pkg_postrm() {
#!/bin/sh
/usr/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}

# FILES plugins/applets/libcardapplet.so* pics/cardmon/*.png sounds/cardmon/*.wav etc/opie-pcmcia.*
do_install() {
        install -d ${D}${palmtopdir}/pics/cardmon/
        install -d ${D}${palmtopdir}/sounds/cardmon/
        install -d ${D}${sysconfdir}/udev/rules.d/
        install -d ${D}${sysconfdir}/udev/scripts/
        install -m 0644 ${WORKDIR}/pics/cardmon/*.png ${D}${palmtopdir}/pics/cardmon/
        install -m 0644 ${WORKDIR}/sounds/cardmon/*.wav ${D}${palmtopdir}/sounds/cardmon/
        install -m 0644 ${WORKDIR}/etc/opie-pcmcia.rules ${D}${sysconfdir}/udev/rules.d/opie-pcmcia.rules
        install -m 0755 ${WORKDIR}/etc/opie-pcmcia.sh ${D}${sysconfdir}/udev/scripts/opie-pcmcia.sh
}

