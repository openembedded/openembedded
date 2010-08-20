include xtables-addons.inc

PR = "${INC_PR}.0"

do_unpack[depends] += "xz-native:do_populate_staging"

SRC_URI = " \
        ${SOURCEFORGE_MIRROR}/project/${PN}/Xtables-addons/${PV}/${PN}-${PV}.tar.xz \
	"
SRC_URI[md5sum] = "b94fe23370a1294b985e9a06a0f9d129"
SRC_URI[sha256sum] = "3d06d6d1d8b8adeae7c9edee20ffd3f2a754eb0b187e8b9f397666e26a7dbbcc"