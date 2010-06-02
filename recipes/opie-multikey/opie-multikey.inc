DESCRIPTION = "Multiple language keyboard"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libqtaux2 opie-pickboard"
RDEPENDS_${PN} = "opie-pics opie-pickboard"
RRECOMMENDS_${PN} = "opie-multikeyapplet"
APPNAME = "qmultikey"

S = "${WORKDIR}/multikey"

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

# FILES plugins/inputmethods/libqmultikey.so* share/multikey/*

SRC_URI_append = " file://ru.keymap"

do_install() {
	install -d ${D}${palmtopdir}/share/multikey/
	install -m 0644 ${WORKDIR}/share/multikey/*.keymap ${D}${palmtopdir}/share/multikey/
	install -m 0644 ${WORKDIR}/share/multikey/README ${D}${palmtopdir}/share/multikey/
	install -m 0644 ${WORKDIR}/ru.keymap ${D}${palmtopdir}/share/multikey/
}

