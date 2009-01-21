DESCRIPTION = "Pingus is a free Lemmings clone."
DEPENDS = "virtual/libsdl libsdl-image libsdl-mixer boost libpng"
LICENSE = "GPL"
HOMEPAGE = "http://pingus.seul.org/"
SECTION = "x11/games"
PV = "0.7.2"
PR = "r0"

inherit scons

SRC_URI = "\
  http://pingus.seul.org/files/pingus-0.7.2.tar.bz2 \
  file://sconstruct.diff;patch=1 \
  file://pingus.desktop \
  file://pingus.png \
  file://pingus-gta012.sh \
"
S = "${WORKDIR}/pingus-0.7.2"

do_install() {
	install -d ${D}${bindir}
        install -d ${D}${datadir}/pingus
	install -d ${D}${datadir}/pixmaps
	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/pingus.png ${D}${datadir}/pixmaps
	cp -a ${S}/data ${D}/${datadir}/pingus
	install -m 0644 ${WORKDIR}/pingus.desktop ${D}${datadir}/applications

	# specialized start script for OM devices
	if test "${MACHINE}" = om-gta01 || test "${MACHINE}" = om-gta02 ; then
		install -m 0755 ${WORKDIR}/pingus-gta012.sh ${D}${bindir}/pingus
		install -m 0755 ${S}/pingus ${D}${bindir}/pingus.bin
	else
		install -m 0755 ${S}/pingus ${D}${bindir}/pingus
	fi
}

FILES_${PN} += "${datadir}"

