DESCRIPTION = "GNOME default webbrowser extensions"
DEPENDS = "epiphany"

inherit gnome

FILES_${PN} += " \
                ${datadir}/epiphany/icons \
                ${libdir}/epiphany/2.28/extensions \
               "

FILES_${PN}-dbg += " \
                ${libdir}/epiphany/2.28/extensions/.debug \
               "



SRC_URI[archive.md5sum] = "7fca4c4d487e3a43ef5adb2a764b9aaf"
SRC_URI[archive.sha256sum] = "17c450622752cbda0e41fffd496d3022a533659f3db942e14da8015c47623856"
