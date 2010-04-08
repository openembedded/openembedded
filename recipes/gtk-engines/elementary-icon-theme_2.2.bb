DESCRIPTION = "Icon theme from the Elementary project"
SECTION = "x11/icons"
HOMEPAGE = "http://www.elementary-project.com/"

inherit gtk-icon-cache

# We have to get the icons from a mirror (LaunchPad) as DeviantArt has a download 
# wrapper to stop simple HTTP gets :(.

SRC_URI = " \
  http://launchpad.net/elementaryicons/2.0/2.2/+download/elementary_2.2.tar.gz;name=archive \
"

SRC_URI[archive.md5sum] = "fb740a046d8d728613499a77b77bc1e2"
SRC_URI[archive.sha256sum] = "49672fc965b30cc6c5c2589a1b72c5187a2d185e7f6d599968172fd694f28ea6"

S = "${WORKDIR}/elementary_2.2"

do_install() {
        install -d ${D}${datadir}/icons/
        install -d ${D}${datadir}/icons/elementary/
        cp -r ${S}/* "${D}${datadir}/icons/elementary/"
}

FILES_${PN} = "${datadir}/icons/elementary/"
RDEPENDS_${PN} += "gnome-icon-theme"
PACKAGE_ARCH = "all"

