DESCRIPTION = "GameBoy Emulator based on SDL, QtE based Palmtop Environments Edition"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe"

SRC_URI = "http://www.warmi.net/zaurus/files/gnuboy-${PV}-qtopia3.tar.gz \
           file://qtopiagnuboyl-hwkeys.patch;patch=1 \
           file://gcc3.patch;patch=1"
S = "${WORKDIR}/gnuboy"

FILES = ""
FILES_${PN} = "${palmtopdir}/"

inherit qmake-base

qtopiadir = "${S}/gnuboy-${PV}-qtopia2"

do_compile() {
	cd ${qtopiadir}
	oe_runmake -f Makefile.qtopia SYS_INCS="-DQWS -I${qtopiadir}/sys/nix" CXXFLAGS="${CXXFLAGS} -DQWS -fno-rtti -fno-exceptions" \
                           QTOPIA_LIBS="-L${STAGING_LIBDIR} -Wl,-rpath-link,${STAGING_LIBDIR} -lqpe -lqte" LD="${CC}"
        cd ${S}/qtopiagnuboyl
	${QMAKE} -spec ${QMAKESPEC} -after ${EXTRA_QMAKEVARS_POST} qtopiagnuboyl.pro
	oe_runmake CXXFLAGS="${CXXFLAGS} -DQWS -fno-rtti -fno-exceptions"
}

do_install() {
        install -m 755 -d ${D}${palmtopdir}/
        install -m 755 -D qpe/bin/qtopiagnuboy ${D}${palmtopdir}/bin/qtopiagnuboy
        install -m 755 -D qpe/bin/qtopiagnuboyl ${D}${palmtopdir}/bin/qtopiagnuboyl
        install -m 644 -D qpe/pics/Gnuboy.png ${D}${palmtopdir}/pics/Gnuboy.png
        install -m 644 -D qpe/apps/Games/qtopiagnuboy.desktop ${D}${palmtopdir}/Games/qtopiagnuboy.desktop
}
