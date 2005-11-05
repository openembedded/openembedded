DESCRIPTION = "Dasher text input method"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "qdasher"


S = "${WORKDIR}/dasher"

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

# FILES plugins/inputmethods/libqdasher.so* share/dasher/alphabet.xml
# FILES share/dasher/training_*.txt
do_install() {
	install -d ${D}${palmtopdir}/share/dasher/
	install -m 0644 ${WORKDIR}/share/dasher/alphabet.xml ${D}${palmtopdir}/share/dasher/
	for f in ${WORKDIR}/share/dasher/training_*.txt
	do
#		echo Installing Dasher Language $f
		[ -f $f ] && install -m 0644 $f ${D}${palmtopdir}/share/dasher/
	done
}

PACKAGES = " opie-dasher-english opie-dasher "

FILES_opie-dasher = "${palmtopdir}/plugins/inputmethods/libqdasher.so*"
FILES_opie-dasher-english = "${palmtopdir}/share/dasher/training_english_GB.txt"

