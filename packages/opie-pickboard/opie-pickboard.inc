DESCRIPTION = "Pickboard input method"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "qpickboard"

S = "${WORKDIR}/pickboard"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  ${bindir}/qcop QPE/TaskBar "reloadApplets()"
else
  exit 0
fi
}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
${bindir}/qcop QPE/TaskBar "reloadInputMethods()"
}


do_stage() {
	install -m 0755 libqpickboard.so ${STAGING_LIBDIR}/
	install pickboardcfg.h ${STAGING_INCDIR}/
	install pickboardpicks.h ${STAGING_INCDIR}/
}

# FILES plugins/inputmethods/libqpickboard.so*
