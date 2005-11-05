DESCRIPTION = "A Game with fishes, Qt/Embedded based Palmtop Environments Edition"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
SECTION = "opie/games"
LICENSE = "GPL"
PRIORITY = "optional"
PR = "r2"

SRC_URI = "http://taiga0818.hp.infoseek.co.jp/rpms/qfish2-${PV}.tar.gz"
S = "${WORKDIR}/qfish"

inherit palmtop

MACHTYPE = "sl300"
MACHTYPE_c7x0     = "sl700"
MACHTYPE_tosa     = "sl700"

do_configure_append() {
	ln -v -f -s config/config-${MACHTYPE}.h config.h
	ln -v -f -s config/config.mk-${MACHTYPE} config.mk
	if [ "${MACHTYPE}" = "sl300" ]
	then
		ln -vfs bigFishSize.h areaSize.h
	else
		ln -vfs smallFishSize.h areaSize.h
	fi
	ln -v -f -s HiScoreRegConfig-${MACHTYPE}.h HiScoreRegConfig.h
}

do_compile_prepend() {
	cd images && oe_runmake && cd ${S}
}

do_install() {
	install -d ${D}${palmtopdir}/apps/Games
	install -m 0644 desktop/qfish-${MACHTYPE}.desktop ${D}${palmtopdir}/apps/Games/qfish2.desktop
	install -d ${D}${palmtopdir}/bin
	install -m 0755 qfish ${D}${palmtopdir}/bin/qfish2
	install -d ${D}${palmtopdir}/pics
	install -m 0644 desktop/qfish2.png ${D}${palmtopdir}/pics/
	install -d ${D}${palmtopdir}/sounds/qfish2
	install -m 0644 sounds/*.wav ${D}${palmtopdir}/sounds/qfish2/
	install -d ${D}${palmtopdir}/help/html/
	install -m 0644 desktop/qfish.html ${D}${palmtopdir}/help/html/qfish2.html
}
