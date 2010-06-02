DESCRIPTION = "Voice Memo Recorder Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "opie-vmemo-settings"
I18N_FILES = "libvmemoapplet.ts"
APPNAME = "vmemoapplet"


S = "${WORKDIR}/vmemo"

inherit opie

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /usr/bin/qcop QPE/TaskBar "reloadApplets()"
fi
 if [ -n "$D" ]; then exit 1; fi
}

pkg_postrm() {
#!/bin/sh
/usr/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then exit 1; fi
}

# FILES plugins/applets/libvmemoapplet.so*
do_install() {
}

