require module-init-tools.inc
inherit cross
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/kernel/module-init-tools/module-init-tools-${PV}.tar.bz2"
EXTRA_OECONF += "--disable-builddir"
#DEPENDS += "docbook-utils-native"

DEFAULT_PREFERENCE = "0"
PROVIDES += "virtual/${TARGET_PREFIX}depmod virtual/${TARGET_PREFIX}depmod-2.6"

# Remove the RDEPENDS_${PN} we picked up from the "require";
# it's simply extraneous for the cross package
RDEPENDS_${PN} = ""

EXTRA_OECONF_append = " --program-prefix=${TARGET_PREFIX}"

do_install_append () {
        mv ${D}${bindir}/${TARGET_PREFIX}depmod ${D}${bindir}/${TARGET_PREFIX}depmod-2.6
}

do_configure_prepend() {
	sed -i -e /MAN5\ =/d -e /MAN8\ =/d Makefile.am 
}

SRC_URI[md5sum] = "8b2257ce9abef74c4a44d825d23140f3"
SRC_URI[sha256sum] = "d012ab07ea26721467a85a775f34747c1c8897e37f16bec5317d8a72ef8b4f17"
