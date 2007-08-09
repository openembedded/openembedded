
DEPENDS = "gtk+ libxt"

PR = "r3"

SVN_REV = "${@bb.data.getVar('PV',d,1).replace('r', '')}"

SRC_URI = "svn://ixion.tartarus.org/main;module=puzzles;proto=svn;rev=${SVN_REV} \
           file://game.png"

S = "${WORKDIR}/puzzles"

do_configure () {
	./mkfiles.pl
}

do_compile_prepend = " \
        export XLDFLAGS='${LDFLAGS} `${STAGING_BINDIR_NATIVE}/pkg-config gtk+-2.0 --libs`'; \
	export CFLAGS='${CFLAGS} -I./ `${STAGING_BINDIR_NATIVE}/pkg-config gtk+-2.0 --cflags`'; "

FILES_${PN} = "${prefix}/games/* ${datadir}/applications/* ${datadir}/pixmaps"
FILES_${PN}-dbg += "${prefix}/games/.debug"

do_install () {
    rm -rf ${D}/*
    export prefix=${D}
    export DESTDIR=${D}
    install -d ${D}/${prefix}/
    install -d ${D}/${prefix}/games/
    oe_runmake install

    install -d ${D}/${datadir}/
    install -d ${D}/${datadir}/applications/
    install -d ${D}/${datadir}/pixmaps/

    install ${WORKDIR}/game.png ${D}/${datadir}/pixmaps/

    cd ${D}/${prefix}/games
    for prog in *; do
	if [ -x $prog ]; then
	    echo "making ${D}/${datadir}/applications/$prog.desktop"
	    cat <<STOP > ${D}/${datadir}/applications/$prog.desktop
[Desktop Entry]
Encoding=UTF-8
Name=$prog
Exec=${prefix}/games/$prog
Icon=game.png
Terminal=false
Type=Application
Categories=Game
StartupNotify=true
SingleInstance=true
STOP
        fi
    done
}
