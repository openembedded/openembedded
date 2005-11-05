DESCRIPTION = "Handwriting input method"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "qhandwriting"


S = "${WORKDIR}/handwriting"

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

# FILES plugins/inputmethods/libqhandwriting.so*
do_install() {
	install -d ${D}${palmtopdir}/etc/qimpen/
	for f in ../qimpen/*
	do
		[ -f $f ] && install -m 0644 $f ${D}${palmtopdir}/etc/qimpen/
	done
}

PACKAGES = " opie-handwriting-classicset opie-handwriting-graffitiset opie-handwriting "

FILES_opie-handwriting = "${palmtopdir}/plugins/inputmethods/libqhandwriting.so*"
FILES_opie-handwriting-classicset = "${palmtopdir}/etc/qimpen/default.conf \
	${palmtopdir}/etc/qimpen/combining.qpt \
	${palmtopdir}/etc/qimpen/asciilower.qpt \
	${palmtopdir}/etc/qimpen/asciiupper.qpt \
	${palmtopdir}/etc/qimpen/numeric.qpt"
FILES_opie-handwriting-graffitiset = "${palmtopdir}/etc/qimpen/graffiti*"

