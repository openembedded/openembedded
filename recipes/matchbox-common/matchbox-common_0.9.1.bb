DESCRIPTION = "Matchbox window manager common files"
SECTION = "x11/wm"
LICENSE = "GPL"
DEPENDS = "libmatchbox"
RDEPENDS_${PN} += "matchbox-panel"
PR = "r7"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz \
           file://no-utilities-category.patch \
           file://add-media-category.patch"

SRC_URI_append_jlime = " http://jlime.com/downloads/development/software/matchbox-icons.tar.gz;name=addons \
			 file://jlime-vfolders.patch "

inherit autotools pkgconfig update-alternatives

do_configure_prepend_jlime() {
	mv ${WORKDIR}/icons/* ${S}/icons
}

EXTRA_OECONF = "--enable-pda-folders"

FILES_${PN} = "\
  ${bindir} \
  ${datadir}/matchbox/vfolders \
  ${datadir}/pixmaps"

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/matchbox-session"
ALTERNATIVE_PRIORITY = "11"

PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "90acc81aeebc0dca8f88fbaa40166607"
SRC_URI[sha256sum] = "cb56d6a1031c33b98751cb06b2fce73feba49cb38a1e4db1a104e8efdfb9a7dc"

SRC_URI[addons.md5sum] = "4613553e3ff3dc53d3bd1b9e01266727"
SRC_URI[addons.sha256sum] = "b35ee2c5d68275fbb598fd8dc0a77899dc5e34e4c1d94fbb3277136604ddac6a"
