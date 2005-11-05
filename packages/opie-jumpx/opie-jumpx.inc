DESCRIPTION = "JumpX input method"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "qjumpx"


S = "${WORKDIR}/jumpx"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadInputMethods()"
else
  exit 0
fi

}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadInputMethods()"
}

# FILES plugins/inputmethods/libqjumpx.so* pics/jumpx
do_install() {
	install -d ${D}${palmtopdir}/pics/jumpx/
	install -m 0644 ${WORKDIR}/pics/jumpx/*.png ${D}${palmtopdir}/pics/jumpx/
}

