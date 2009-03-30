DESCRIPTION = "Custom Keyboard \
Keyboard that can be customized to include exactly the characters that the user uses, but which is not available on his physical keyboard."
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.blackie.dk/Zaurus/custominput/"
AUTHOR = "Jesper Kjaer Pedersen <blackie@blackie.dk>"

SRC_URI = "http://www.blackie.dk/Zaurus/custominput/custominput-1.1.0.tgz"

inherit palmtop

QMAKE_PROFILES = "custominput.pro"

EXTRA_QMAKEVARS_POST += "DESTDIR=${S}"

do_configure_prepend() {
	find ${S} -name Makefile|xargs rm
}

do_install() {

	install -d ${D}${palmtopdir}/plugins/inputmethods/ \
			   ${D}${palmtopdir}/pics/ \
			   ${D}${palmtopdir}/bin/ \
			   ${D}${palmtopdir}/apps/ \
			   ${D}${palmtopdir}/apps/Settings/ \
			   ${D}${palmtopdir}/help/html/

	install -m 0755 ${S}/customInputConfig		${D}${palmtopdir}/bin/
	install -m 0644 ${S}/custominput.desktop	${D}${palmtopdir}/apps/Settings/
	install -m 0644 ${S}/customInputConfig.html ${D}${palmtopdir}/help/html/
	install -m 0644 ${S}/custominput.png		${D}${palmtopdir}/pics/
	oe_libinstall -so -C ${S}/ libcustominput	${D}${palmtopdir}/plugins/inputmethods/

}
