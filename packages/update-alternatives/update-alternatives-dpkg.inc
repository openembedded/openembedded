LICENSE = "GPL"
SECTION = "base"
SRC_URI += "${DEBIAN_MIRROR}/main/d/dpkg/dpkg_${PV}.tar.gz"
S = "${WORKDIR}/dpkg-${PV}"
PACKAGE_ARCH = "all"

SRC_URI += "file://paths.patch;patch=1"

do_patch_append () {
	import shutil
	update_alternatives_src = bb.data.getVar('S', d, 1)
	shutil.move("%s/scripts/update-alternatives.pl" % (update_alternatives_src,),
	            "%s/scripts/update-alternatives" % (update_alternatives_src,))
}
