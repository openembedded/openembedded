require unrar.inc

do_install() {
    install -d ${D}${bindir}
    install -m 0755 unrar ${D}${bindir}
}
