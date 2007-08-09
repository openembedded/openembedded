DESCRIPTION = "The OpenMoko Command Line Console"
SECTION = "openmoko/applications"
RDEPENDS += "gtkterm2"
PV = "1.0.0"
PR = "r1"

inherit openmoko

SRC_URI = "file://openmoko-terminal.png \
           file://openmoko-terminal.desktop \
           file://gtkterm2rc"

do_install() {
        install -d ${D}${sysconfdir}/skel
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/openmoko-terminal.png ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/openmoko-terminal.desktop ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/gtkterm2rc ${D}${sysconfdir}/skel/.gtkterm2rc
}

pkg_postinst_openmoko-terminal() {
#!/bin/sh -e
if [ "x$D" != "x" ]; then
    exit 1 # don't run at image generation time
else
    if [ -e "$HOME/.gtkterm2rc" ]; then
        echo "not overriding $HOME/.gtkterm2rc"
    else
        echo "installing $HOME/.gtkterm2rc from /etc/skel"
        cp -f ${sysconfdir}/skel/.gtkterm2rc $HOME/
    fi
fi
}
