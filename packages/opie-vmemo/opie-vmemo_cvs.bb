DESCRIPTION = "Voice Memo Recorder Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "opie-vmemo-settings"
PV = "1.1.8+cvs-${CVSDATE}"
I18N_FILES = "libvmemoapplet.ts"
APPNAME = "vmemoapplet"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/vmemo \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/vmemo"

inherit opie

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
fi
 if [ -n "$D" ]; then exit 1; fi
}

pkg_postrm() {
#!/bin/sh
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then exit 1; fi
}

# FILES plugins/applets/libvmemoapplet.so*
do_install() {
}

