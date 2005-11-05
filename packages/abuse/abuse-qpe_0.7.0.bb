SECTION = "opie/games"

include abuse_${PV}.bb

DEPENDS += "virtual/libqpe"

EXTRA_CXXFLAGS_append = " -Dmain=SDL_main"
EXTRA_CFLAGS_append = " -Dmain=SDL_main"
EXTRA_LFLAGS_append = "-lqpe"

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/apps/Games \
        	   ${D}${palmtopdir}/share/aliens
        install -D -m 0755 aliens ${D}${palmtopdir}/bin/aliens
	install -D -m 0644 aliens.png ${D}${palmtopdir}/pics/aliens.png
        install -D -m 0644 aliens.desktop ${D}${palmtopdir}/Games/aliens.desktop
}
