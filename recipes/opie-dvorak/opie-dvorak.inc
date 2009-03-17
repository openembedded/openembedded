DESCRIPTION = "Dvorak keyboard input method"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-pickboard"
RDEPENDS = "opie-pickboard"
APPNAME = "qdvorak"

S = "${WORKDIR}/dvorak"

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

# FILES plugins/inputmethods/libqdvorak.so*
do_install() {
}

