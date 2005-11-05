DESCRIPTION = "Applet to disable the automatic screen rotation on Zaurus C-models"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "autorotateapplet"


S = "${WORKDIR}/${APPNAME}"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
else
  exit 0
fi
}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
}

# FILES plugins/applets/libautorotateapplet.so* pics/autorotate/*.png
do_install() {
	install -d ${D}${palmtopdir}/pics/autorotate/
	install -m 0655 ${WORKDIR}/pics/autorotate/*.png ${D}${palmtopdir}/pics/autorotate/
}
