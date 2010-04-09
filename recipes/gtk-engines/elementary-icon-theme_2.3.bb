DESCRIPTION = "Icon theme from the Elementary project"
SECTION = "x11/icons"
HOMEPAGE = "http://www.elementary-project.com/"

inherit gtk-icon-cache

# We have to get the icons from a mirror (LaunchPad) as DeviantArt has a download 
# wrapper to stop simple HTTP gets :(.

SRC_URI = " \
  http://launchpad.net/elementaryicons/2.0/2.3/+download/elementary-monochrome.tar.gz;name=mono \
  http://launchpad.net/elementaryicons/2.0/2.3/+download/elementary.tar.gz;name=regular \
"

SRC_URI[mono.md5sum] = "986a2475e9953450b37912d154bb325d"
SRC_URI[mono.sha256sum] = "da461bd70b2fda633f26aa7495e1efc5d97815661799566f0a8accaea411272f"

SRC_URI[regular.md5sum] = "674a88984f55170c17298863f72dd34d"
SRC_URI[regular.sha256sum] = "f7cacfd0e4d3c9ea1c84b29a4f2c75fa1066d6c7f9b41ca0b96ae033c23992a6"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/icons/elementary/
	install -d ${D}${datadir}/icons/elementary-monochrome/

	cp -r ${S}/elementary/* ${D}${datadir}/icons/elementary/
	cp -r ${S}/elementary-monochrome/* ${D}${datadir}/icons/elementary-monochrome/
}

FILES_${PN} = "${datadir}/icons/elementary*"
RDEPENDS_${PN} += "gnome-icon-theme"
PACKAGE_ARCH = "all"

