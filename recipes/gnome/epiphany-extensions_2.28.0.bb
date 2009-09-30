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


