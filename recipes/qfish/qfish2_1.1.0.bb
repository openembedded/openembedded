DESCRIPTION = "A Game with fishes, Qt/Embedded based Palmtop Environments Edition"
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

SRC_URI[md5sum] = "2a8219bcb375fac66cea66394c3c36fa"
SRC_URI[sha256sum] = "1e097fdccda0fc914c8229aab7d83964c5944cc95eb053fd69e357dca69461b9"
