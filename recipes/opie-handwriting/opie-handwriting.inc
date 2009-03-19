DESCRIPTION = "Handwriting input method"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "qhandwriting"


S = "${WORKDIR}/handwriting"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  ${bindir}/qcop QPE/TaskBar "reloadInputMethods()"
else
  exit 0
fi

}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
${bindir}/qcop QPE/TaskBar "reloadInputMethods()"
}

# FILES plugins/inputmethods/libqhandwriting.so*
do_install() {
	install -d ${D}${palmtopdir}/etc/qimpen/
	for f in ../qimpen/*
	do
		[ -f $f ] && install -m 0644 $f ${D}${palmtopdir}/etc/qimpen/
	done
}

PACKAGES += " opie-handwriting-classicset opie-handwriting-graffitiset "

FILES_${PN} = "${palmtopdir}/plugins/inputmethods/libqhandwriting.so*"
FILES_opie-handwriting-classicset = "${palmtopdir}/etc/qimpen/default.conf \
	${palmtopdir}/etc/qimpen/combining.qpt \
	${palmtopdir}/etc/qimpen/asciilower.qpt \
	${palmtopdir}/etc/qimpen/asciiupper.qpt \
	${palmtopdir}/etc/qimpen/numeric.qpt"
FILES_opie-handwriting-graffitiset = "${palmtopdir}/etc/qimpen/graffiti*"

