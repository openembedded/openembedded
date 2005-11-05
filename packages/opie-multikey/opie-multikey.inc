DESCRIPTION = "Multiple language keyboard"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libqtaux2 opie-pickboard"
RDEPENDS = "opie-pics opie-pickboard"
APPNAME = "qmultikey"

S = "${WORKDIR}/multikey"

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

# FILES plugins/inputmethods/libqmultikey.so* share/multikey/*
do_install() {
	install -d ${D}${palmtopdir}/share/multikey/
	install -m 0644 ${WORKDIR}/share/multikey/*.keymap ${D}${palmtopdir}/share/multikey/
	install -m 0644 ${WORKDIR}/share/multikey/README ${D}${palmtopdir}/share/multikey/
}

