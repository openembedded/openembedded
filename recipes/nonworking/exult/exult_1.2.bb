DESCRIPTION = "Exult is a project to create an Ultima 7 game engine that runs on modern operating systems, \
capable of using the data and graphics files that come with the game. Qt/E based Palmtop Environments Edition w/ SDL"
SECTION = "opie/games"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe libsdl-mixer zlib freetype"
SRC_URI = "${SOURCEFORGE_MIRROR}/exult/exult-${PV}.tar.gz"
inherit autotools

#FIXME: Add compatible host or so, it is zaurus specific atm.

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

EXTRA_OECONF = "-host=arm-embeddix-linux-gnu \
                --disable-exult-studio-support \
                --disable-debug \
                --disable-exult-studio \
                --disable-gimp-plugin \
                --disable-tools \
                --disable-compiler \
                --enable-data \
                --disable-timidity \
                --disable-kmid \
                --with-vorbis-prefix=${STAGING_LIBDIR}/.. \
                --with-mpeg2-prefix=${STAGING_LIBDIR}/.. \
                --with-mad-prefix=${STAGING_BINDIR_CROSS}/.. "

#CXXFLAGS_append = " -Dmain=SDL_main"
#CFLAGS_append = " -Dmain=SDL_main"

do_install() {
       install -d ${D}/${palmtopdir}/bin \
                          ${D}/${palmtopdir}/data
        install -m 0755 exult ${D}/${palmtopdir}/bin/exult
        install -m 0755 data/exult.flx ${D}/${palmtopdir}/data
        install -m 0755 data/exult_bg.flx ${D}/${palmtopdir}/data
        install -m 0755 data/exult_si.flx ${D}/${palmtopdir}/data
        install -m 0755 data/midisfx.flx ${D}/${palmtopdir}/data

        echo "[Desktop Entry]" >${D}/${palmtopdir}/apps/Games/exult.desktop
        echo "Comment=Exult game" >>${D}/${palmtopdir}/apps/Games/exult.desktop
        echo "Exec=exult" >>${D}/${palmtopdir}/apps/Games/exult.desktop
        echo "Icon=exult" >>${D}/${palmtopdir}/apps/Games/exult.desktop
        echo "Type=Application" >>${D}/${palmtopdir}/apps/Games/exult.desktop
        echo "Name=Exult" >>${D}/${palmtopdir}/apps/Games/exult.desktop
}

FILES_${PN} = "${palmtopdir}"

SRC_URI[md5sum] = "0fc88dee74a91724d25373ba0a8670ba"
SRC_URI[sha256sum] = "a6dd9d4e399281ed2db691ede21dbb79818ee11b08ef717e3eac255e290cf21a"
