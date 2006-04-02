DEPENDS_prepend = "coreutils-native virtual/libintl intltool-native "
GPE_TARBALL_SUFFIX ?= "gz"
SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.${GPE_TARBALL_SUFFIX}"
FILES_${PN} += "${datadir}/gpe ${datadir}/application-registry"

# can't set this directly!
GPE_MAINTAINER = "GPE Team <gpe@handhelds.org>"

inherit gettext

gpe_do_compile() {
	oe_runmake PREFIX=${prefix}
}

gpe_do_install() {
	oe_runmake PREFIX=${prefix} DESTDIR=${D} install
}

python do_package_prepend () {
	maintainer = bb.data.getVar("MAINTAINER", d, 1)
	default_maintainer = bb.data.getVar("DEFAULT_MAINTAINER", d, 1)
	gpe_maintainer = bb.data.getVar("GPE_MAINTAINER", d, 1)

	if default_maintainer and maintainer == default_maintainer:
		bb.data.setVar("MAINTAINER", gpe_maintainer, d)

}

EXPORT_FUNCTIONS do_compile do_install
