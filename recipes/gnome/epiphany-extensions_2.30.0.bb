DESCRIPTION = "GNOME default webbrowser extensions"
DEPENDS = "epiphany"

inherit gnome

SRC_URI[archive.md5sum] = "76dd4f6296a259d09554e693336187a2"
SRC_URI[archive.sha256sum] = "cf2e7c8ea8cc34740d945ffa7b877dbe9f047b43f8609f6d78c6811ca69efe24"

FILES_${PN} += " \
                ${datadir}/epiphany/icons \
                ${libdir}/epiphany/2.30/extensions \
               "

FILES_${PN}-dbg += " \
                ${libdir}/epiphany/2.30/extensions/.debug \
               "


