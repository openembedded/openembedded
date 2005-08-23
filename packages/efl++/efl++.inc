DESCRIPTION = "C++ Bindings for the Enlightenment Foundation Libraries"
SECTION = "e/libs"
LICENSE = "LGPL"
AUTHOR = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
MAINTAINER = "${AUTHOR}"
HOMEPAGE = "http://www.Vanille.de/projects/efl++.html"
DEPENDS = "virtual/evas virtual/ecore edje"
PROVIDES = "virtual/efl++"

SRC_URI = "http://www.Vanille.de/temp/efl++_${PV}.tar.bz2"
S = "${WORKDIR}/efl++-${PV}"

inherit qmake

PARALLEL_MAKE = ""
QMAKE_PROFILES = "efl++.pro"
EXTRA_QMAKEVARS_POST = "INCLUDEPATH+=${S}/src/misc INCLUDEPATH+=${S}/src/common \
			INCLUDEPATH+=${S}/src/evas INCLUDEPATH+=${S}/src/ecore INCLUDEPATH+=${S}/src/edje \
			LIBS+=-L${S} DESTDIR=${S} ${EFL_CONFIGURATION}"
export OE_QMAKE_LINK="${CXX}"
export EDIR="${S}"

do_configure_prepend() {
	rm include.pro
	cat <<EOF >include.pro
include ( common.pro )
DEFINES += DATADIR=\"${datadir}/efl++/\"
EOF
}

do_stage() {
	for i in src/common/*.h src/evas/*.h src/ecore/*.h src/edje/*.h
	do
		install -m 0644 $i ${STAGING_INCDIR}
	done
	oe_libinstall -so -C ${S} libefl++ ${STAGING_LIBDIR}
}

do_install() {
	oe_libinstall -so -C ${S} libefl++ ${D}${libdir}
	install -d ${D}${bindir}
	install *-* ${D}${bindir}
	install -d ${D}${datadir}/efl++
	cp -a data/* ${D}${datadir}/efl++
}

PACKAGES =+ "efl++-examples"
FILES_${PN} = "${libdir}"
FILES_efl++-examples = "${bindir} ${datadir}"
